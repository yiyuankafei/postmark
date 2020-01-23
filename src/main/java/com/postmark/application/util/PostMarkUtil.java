package com.postmark.application.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class PostMarkUtil {
	
	public static void drawPostMark(Graphics2D graphics, int width, String time, char[] charArray) throws Exception {
		
		//邮戳位置，直径
		double unit = ((double)width) / 3 / 1000;
		int padding = (int)(100 * unit);
		int diam = (int)(800 * unit);
		
		
		graphics.setColor(Color.BLACK);
		graphics.setStroke(new BasicStroke(width / 1000 * 2));
		// RenderingHints.VALUE_ANTIALIAS_ON 抗锯齿
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.drawOval(padding, padding, diam, diam);
		graphics.setFont(new Font("黑体",Font.BOLD,(int)(90*unit)));
		graphics.drawString(time,(int)(250*unit),(int)(550*unit));
		
		graphics.setFont(new Font("宋体",Font.BOLD,(int)(100*unit)));
		graphics.translate((int)(300*unit), (int)(770*unit));
		graphics.rotate(40* Math.PI / 180);
		graphics.drawString("逐",0,0);
		graphics.rotate(-40* Math.PI / 180);
		graphics.translate(-(int)(300*unit), -(int)(770*unit));
		
		graphics.translate((int)(630*unit), (int)(850*unit));
		graphics.rotate(-40* Math.PI / 180);
		graphics.drawString("路",0,0);
		graphics.rotate(40* Math.PI / 180);
		graphics.translate(-(int)(630*unit), -(int)(850*unit));
		
		switch(charArray.length) {
		case 2:
			drawPostMark2(graphics,width,time,charArray);
			break;
		case 3:
			drawPostMark3(graphics,width,time,charArray);
			break;
		case 4:
			drawPostMark4(graphics,width,time,charArray);
			break;
		case 5:
			drawPostMark5(graphics,width,time,charArray);
			break;
		case 6:
			drawPostMark6(graphics,width,time,charArray);
			break;
		}
	}
	
private static void drawPostMark2(Graphics2D graphics, int width, String time, char[] charArray) throws Exception{
	
	
		double unit = ((double)width)/3/1000;
		
		graphics.setFont(new Font("宋体",Font.BOLD,(int)(130*unit)));
		
		graphics.translate((int)(300*unit), (int)(350*unit));
		graphics.rotate(-40* Math.PI / 180);
		graphics.drawString(((Character)charArray[0]).toString(),0,0);
		graphics.rotate(40* Math.PI / 180);
		graphics.translate(-(int)(300*unit),-(int)(350*unit));
		
		graphics.translate((int)(630*unit), (int)(280*unit));
		graphics.rotate(40* Math.PI / 180);
		graphics.drawString(((Character)charArray[1]).toString(),0,0);
		
	}
	
	private static void drawPostMark3(Graphics2D graphics,int width ,String time,char[] charArray) throws Exception{
		double percent = ((double)width)/3/1000;
		graphics.setColor(Color.BLACK);
		graphics.setStroke(new BasicStroke(2));
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.drawOval((int)(100*percent), (int)(100*percent), (int)(800*percent), (int)(800*percent));
		graphics.setFont(new Font("黑体",Font.BOLD,(int)(90*percent)));
		graphics.drawString(time,(int)(250*percent),(int)(550*percent));
		
		
		graphics.setFont(new Font("宋体",Font.BOLD,(int)(100*percent)));
		graphics.translate((int)(300*percent), (int)(770*percent));
		graphics.rotate(40* Math.PI / 180);
		graphics.drawString("逐",0,0);
		graphics.rotate(-40* Math.PI / 180);
		graphics.translate(-(int)(300*percent), -(int)(770*percent));
		
		graphics.translate((int)(630*percent), (int)(850*percent));
		graphics.rotate(-40* Math.PI / 180);
		graphics.drawString("路",0,0);
		graphics.rotate(40* Math.PI / 180);
		graphics.translate(-(int)(630*percent), -(int)(850*percent));
		
		graphics.setFont(new Font("宋体",Font.BOLD,(int)(115*percent)));;
		
		graphics.translate((int)(285*percent), (int)(365*percent));
		graphics.rotate(-40* Math.PI / 180);
		graphics.drawString(((Character)charArray[0]).toString(),0,0);
		graphics.rotate(40* Math.PI / 180);
		graphics.translate(-(int)(285*percent), -(int)(365*percent));
		
		graphics.translate((int)(630*percent), (int)(280*percent));
		graphics.rotate(40* Math.PI / 180);
		graphics.drawString(((Character)charArray[2]).toString(),0,0);
		graphics.rotate(-40* Math.PI / 180);
		graphics.translate(-(int)(630*percent), -(int)(280*percent));
		
		graphics.translate((int)(435*percent), (int)(255*percent));
		graphics.drawString(((Character)charArray[1]).toString(),0,0);
		
	}
	private static void drawPostMark4(Graphics2D graphics,int width ,String time,char[] charArray) throws Exception{
	
		double percent = ((double)width)/3/1000;
		graphics.setColor(Color.BLACK);
		graphics.setStroke(new BasicStroke(2));
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.drawOval((int)(100*percent), (int)(100*percent), (int)(800*percent), (int)(800*percent));
		graphics.setFont(new Font("黑体",Font.BOLD,(int)(90*percent)));
		
		
		
		graphics.drawString(time,(int)(250*percent),(int)(550*percent));
		
		
		graphics.setFont(new Font("宋体",Font.BOLD,(int)(100*percent)));
		graphics.translate((int)(300*percent), (int)(770*percent));
		graphics.rotate(40* Math.PI / 180);
		graphics.drawString("逐",0,0);
		graphics.rotate(-40* Math.PI / 180);
		graphics.translate(-(int)(300*percent), -(int)(770*percent));
		
		graphics.translate((int)(630*percent), (int)(850*percent));
		graphics.rotate(-40* Math.PI / 180);
		graphics.drawString("路",0,0);
		graphics.rotate(40* Math.PI / 180);
		graphics.translate(-(int)(630*percent), -(int)(850*percent));
		graphics.setFont(new Font("宋体",Font.BOLD,(int)(100*percent)));
		
		graphics.translate((int)(255*percent), (int)(375*percent));
		graphics.rotate(-55* Math.PI / 180);
		graphics.drawString(((Character)charArray[0]).toString(),0,0);
		graphics.rotate(55* Math.PI / 180);
		graphics.translate(-(int)(255*percent), -(int)(375*percent));
		
		graphics.translate((int)(685*percent), (int)(295*percent));
		graphics.rotate(55* Math.PI / 180);
		graphics.drawString(((Character)charArray[3]).toString(),0,0);
		graphics.rotate(-55* Math.PI / 180);
		graphics.translate(-(int)(685*percent), -(int)(295*percent));
		
		graphics.translate((int)(375*percent), (int)(250*percent));
		graphics.rotate(-30* Math.PI / 180);
		graphics.drawString(((Character)charArray[1]).toString(),0,0);
		graphics.rotate(30* Math.PI / 180);
		graphics.translate(-(int)(375*percent), -(int)(250*percent));
		
		graphics.translate((int)(550*percent), (int)(210*percent));
		graphics.rotate(30* Math.PI / 180);
		graphics.drawString(((Character)charArray[2]).toString(),0,0);
		
	}
	private static void drawPostMark5(Graphics2D graphics,int width ,String time,char[] charArray) throws Exception{
		double percent = ((double)width)/3/1000;
		graphics.setColor(Color.BLACK);
		graphics.setStroke(new BasicStroke(2));
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.drawOval((int)(100*percent), (int)(100*percent), (int)(800*percent), (int)(800*percent));
		graphics.setFont(new Font("黑体",Font.BOLD,(int)(90*percent)));
		graphics.drawString(time,(int)(250*percent),(int)(550*percent));
		
		graphics.setFont(new Font("宋体",Font.BOLD,(int)(100*percent)));
		graphics.translate((int)(300*percent), (int)(770*percent));
		graphics.rotate(40* Math.PI / 180);
		graphics.drawString("逐",0,0);
		graphics.rotate(-40* Math.PI / 180);
		graphics.translate(-(int)(300*percent), -(int)(770*percent));
		
		graphics.translate((int)(630*percent), (int)(850*percent));
		graphics.rotate(-40* Math.PI / 180);
		graphics.drawString("路",0,0);
		graphics.rotate(40* Math.PI / 180);
		graphics.translate(-(int)(630*percent), -(int)(850*percent));
		graphics.setFont(new Font("宋体",Font.BOLD,(int)(85*percent)));
		
		graphics.translate((int)(235*percent), (int)(385*percent));
		graphics.rotate(-60* Math.PI / 180);
		graphics.drawString(((Character)charArray[0]).toString(),0,0);
		graphics.rotate(60* Math.PI / 180);
		graphics.translate(-(int)(235*percent), -(int)(385*percent));
		
		graphics.translate((int)(325*percent), (int)(265*percent));
		graphics.rotate(-30* Math.PI / 180);
		graphics.drawString(((Character)charArray[1]).toString(),0,0);
		graphics.rotate(30* Math.PI / 180);
		graphics.translate(-(int)(325*percent), -(int)(265*percent));
		
		graphics.translate((int)(470*percent), (int)(200*percent));
		graphics.drawString(((Character)charArray[2]).toString(),0,0);
		graphics.translate(-(int)(470*percent), -(int)(200*percent));
		
		graphics.translate((int)(600*percent), (int)(210*percent));
		graphics.rotate(30* Math.PI / 180);
		graphics.drawString(((Character)charArray[3]).toString(),0,0);
		graphics.rotate(-30* Math.PI / 180);
		graphics.translate(-(int)(600*percent), -(int)(210*percent));
		
		graphics.translate((int)(710*percent), (int)(290*percent));
		graphics.rotate(60* Math.PI / 180);
		graphics.drawString(((Character)charArray[4]).toString(),0,0);
		
	}
	private static void drawPostMark6(Graphics2D graphics,int width ,String time,char[] charArray) throws Exception{
		double percent = ((double)width)/3/1000;
		graphics.setColor(Color.BLACK);
		graphics.setStroke(new BasicStroke(2));
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.drawOval((int)(100*percent), (int)(100*percent), (int)(800*percent), (int)(800*percent));
		graphics.setFont(new Font("黑体",Font.BOLD,(int)(90*percent)));
		graphics.drawString(time,(int)(250*percent),(int)(550*percent));
		
		
		graphics.setFont(new Font("宋体",Font.BOLD,(int)(100*percent)));
		graphics.translate((int)(300*percent), (int)(770*percent));
		graphics.rotate(40* Math.PI / 180);
		graphics.drawString("逐",0,0);
		graphics.rotate(-40* Math.PI / 180);
		graphics.translate(-(int)(300*percent), -(int)(770*percent));
		
		graphics.translate((int)(630*percent), (int)(850*percent));
		graphics.rotate(-40* Math.PI / 180);
		graphics.drawString("路",0,0);
		graphics.rotate(40* Math.PI / 180);
		graphics.translate(-(int)(630*percent), -(int)(850*percent));
		graphics.setFont(new Font("宋体",Font.BOLD,(int)(80*percent)));
		
		graphics.translate((int)(215*percent), (int)(435*percent));
		graphics.rotate(-75* Math.PI / 180);
		graphics.drawString(((Character)charArray[0]).toString(),0,0);
		graphics.rotate(75* Math.PI / 180);
		graphics.translate(-(int)(215*percent), -(int)(435*percent));
		
		graphics.translate((int)(275*percent), (int)(275*percent));
		graphics.rotate(-45* Math.PI / 180);
		graphics.drawString(((Character)charArray[1]).toString(),0,0);
		graphics.rotate(45* Math.PI / 180);
		graphics.translate(-(int)(275*percent), -(int)(275*percent));
		
		graphics.translate((int)(400*percent), (int)(190*percent));
		graphics.rotate(-15* Math.PI / 180);
		graphics.drawString(((Character)charArray[2]).toString(),0,0);
		graphics.rotate(15* Math.PI / 180);
		graphics.translate(-(int)(400*percent), -(int)(190*percent));
		
		graphics.translate((int)(540*percent), (int)(175*percent));
		graphics.rotate(15* Math.PI / 180);
		graphics.drawString(((Character)charArray[3]).toString(),0,0);
		graphics.rotate(-15* Math.PI / 180);
		graphics.translate(-(int)(540*percent), -(int)(175*percent));
		
		graphics.translate((int)(670*percent), (int)(225*percent));
		graphics.rotate(45* Math.PI / 180);
		graphics.drawString(((Character)charArray[4]).toString(),0,0);
		graphics.rotate(-45* Math.PI / 180);
		graphics.translate(-(int)(670*percent), -(int)(225*percent));
		
		graphics.translate((int)(770*percent), (int)(350*percent));
		graphics.rotate(75* Math.PI / 180);
		graphics.drawString(((Character)charArray[5]).toString(),0,0);
		
	}
}
	
		
