package com.postmark.application.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.aliyun.oss.OSSClient;
import com.postmark.application.config.OssConfig;
import com.postmark.application.util.OssUtil;
import com.postmark.application.util.PostMarkUtil;

@Controller
@RequestMapping("/postmark")
public class PostmarkController {
	
	@Autowired
	OssConfig ossConfig;
	
	private static ThreadLocal<SimpleDateFormat>  sdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
	
	private static ExecutorService  cachedThreadPool = Executors.newCachedThreadPool();
	
	private static final String SEPARAT = "/";
	
	private static final String PREFIX = "postmrak" + SEPARAT;
	
	@RequestMapping("/submit")
	public ModelAndView postmark(MultipartFile file, String location, String time) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		//文件后缀
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		
		//上传原图
		Future<String> originPathFuture = cachedThreadPool.submit(new UploadThread(ossConfig, file.getInputStream(), suffix));
		
		//生成邮戳
		BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
		
		BufferedImage newImage = new BufferedImage(width, height, 4);
		Graphics2D graphics = newImage.createGraphics();
		graphics.drawImage(bufferedImage, 0, 0, width, height, null);
		PostMarkUtil.drawPostMark(graphics, width, time, location.toCharArray());
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(newImage, suffix.substring(1), os);
		Future<String> newPathFuture = cachedThreadPool.submit(new UploadThread(ossConfig, new ByteArrayInputStream(os.toByteArray()), suffix));
		
		String originPath = originPathFuture.get();
		String newPath = newPathFuture.get();
		
		mv.setViewName("/show");
		mv.addObject("originPath", originPath);
		mv.addObject("newPath", newPath);
		return mv;
	}
	
	static class UploadThread implements Callable<String> {
		
		private OssConfig ossConfig; 
		
		private InputStream inputStream;
		
		private String suffix;

		public UploadThread(OssConfig ossConfig, InputStream inputStream, String suffix) {
			super();
			this.ossConfig = ossConfig;
			this.inputStream = inputStream;
			this.suffix = suffix;
		}

		@Override
		public String call() throws Exception {
			OSSClient client = OssUtil.getInstance(ossConfig);
			String ossPath = PREFIX + sdf.get().format(new Date()) + SEPARAT + UUID.randomUUID() + suffix;
			String webPath = OssUtil.upload(client, ossPath, inputStream, ossConfig.getBucketName());
			return webPath;
		}
		
	}
	
}
