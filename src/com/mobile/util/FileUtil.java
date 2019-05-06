package com.mobile.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;


public class FileUtil {
    /** 
     * 从输入流中获取数据 
     * @param inStream 输入流 
     * @return 
     * @throws Exception 
     */  
    public static byte[] readInputStream(InputStream inStream) throws Exception{  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        while( (len=inStream.read(buffer)) != -1 ){  
            outStream.write(buffer, 0, len);  
        }  
        inStream.close();  
        return outStream.toByteArray();  
    } 
    
	/**
	 * 创建文件夹
	 * 
	 * @param path
	 * @param isFile
	 */
	public static void createFolder(String path, boolean isFile) {
		if (isFile) {
			path = path.substring(0, path.lastIndexOf(File.separator));
		}
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
	}
	
	/**
	 * 判断文件是否存在
	 * @param dir
	 * @return
	 */
	public static boolean isExistFile(String dir){
		boolean isExist=false;
		File fileDir=new File(dir);
		if(fileDir.isDirectory()){
			File[] files=fileDir.listFiles();
			if(files!=null&&files.length!=0){
				isExist=true;
			}
		}
		return isExist;
	}
	
	/**
	 * 将列表 图片写入到磁盘  
	 * @param img
	 * @param expand
	 * @throws Exception
	 */
    public static void writeImageListToDisk(byte[] img,String imagePath,String imagFileName) throws Exception{  
        	MobileUtil mu = new MobileUtil();
        	//得到网络图片的名称
        	createFolder(imagePath,true);//创建文件 
        	File file = new File(imagePath);
        	//判断文件是否存在,不存在则下载
        	if(!isExistFile(imagePath)){ 
        		 FileOutputStream fops = new FileOutputStream(file);
                 fops.write(img);
                 fops.flush();  
                 fops.close(); 
        	}
    }
    
    
    /** 
     * 复制单个文件 
     * @param oldPath String 原文件路径 如：c:/fqf.txt 
     * @param newPath String 复制后路径 如：f:/fqf.txt 
     * @return boolean 
     */ 
   public static String copyFile(String oldPath, String newPath) { 
       try { 
           int bytesum = 0; 
           int byteread = 0; 
           File oldfile = new File(oldPath); 
           if (oldfile.exists()) {                  //文件存在时 
               InputStream inStream = new FileInputStream(oldPath);      //读入原文件 
               FileOutputStream fs = new FileOutputStream(newPath); 
               byte[] buffer = new byte[1444]; 
               int length; 
               while ( (byteread = inStream.read(buffer)) != -1) { 
                   bytesum += byteread;            //字节数 文件大小 
                   fs.write(buffer, 0, byteread); 
               } 
               inStream.close(); 
               return "ok";
           } 
       }  catch (Exception e) { 
           System.out.println("复制单个文件操作出错"); 
           e.printStackTrace(); 
       } 
       
       return "no";
   } 
    public static void main(String[] args) {
    	createFolder("E:\\Temp\\userInfoImage\\appFile\\说明.txt",true);
	}
}
