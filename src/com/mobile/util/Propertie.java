package com.mobile.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propertie {
	private static String headProtraitFile;//头像文件名称 
	private static String appDownloadFile;//app文件名称 
	private static String FilePath;//文件存放路径 
	private static String defaultImage;//头像默认地址 
	private static int tokenVaditeTime=30;//口令 有效期 
	static {
		 Properties p = new Properties();
		try {  
		        InputStream in = Propertie.class.getResourceAsStream("/conf/app.properties");
		        p.load(in);  
		        in.close();  
		        if(p.containsKey("FilePath")){
		        	FilePath=p.getProperty("FilePath");
		        }
		        if(p.containsKey("headProtraitFile")){ 
		        	headProtraitFile = p.getProperty("headProtraitFile");
		        }
		        
		        if(p.containsKey("appDownloadFile")){ 
		        	appDownloadFile = p.getProperty("appDownloadFile");
		        }
		        
		        if(p.containsKey("defaultImage")){ 
		        	defaultImage = p.getProperty("defaultImage");
		        }
		        if(p.containsKey("tokenVaditeTime")){ 
		        	tokenVaditeTime = p.getProperty("tokenVaditeTime")==null?30:Integer.parseInt(p.getProperty("tokenVaditeTime"));
		        }
	    } catch (IOException ex) {  
	       ex.printStackTrace();
	    }  
	}
	/**
	 * 人员头像 文件夹  存放地址
	 * @return
	 */
	public static String getHeadProtraitFile() {
		return headProtraitFile;
	}
	/**
	 * app文件上传 文件夹 地址
	 * @return
	 */
	public static String getAppDownloadFile() {
		return appDownloadFile;
	}
	/**
	 * 文件的磁盘更目录 地址
	 * @return
	 */
	public static String getFilePath() {
		return FilePath;
	}
	public static String getDefaultImage() {
		return defaultImage;
	}
	public static int getTokenVaditeTime() {
		return tokenVaditeTime;
	}
	
}
