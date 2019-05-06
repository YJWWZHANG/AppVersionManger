package com.mobile.appversion.util;


public class AppVersionPushUtil {
	/**
	 * 安卓版本更新值 
	 */
	public   static final String  ANDROID  ="ab55ce55Ac4bcP408cPb8c1Aaeac179c5f6f";
	/**
	 * 苹果 版本更新值 
	 */
	public   static final String  IOS ="37hpy7toI7xrh5dv2nnqcOyuivpcf3fS2yv";
    /**
	 * 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0
	 * @param version1当前版本号 
	 * @param version2数据库中版本号
	 */
	public static int compareVersion(String curentVersion1, String oldVersion2) throws Exception {
	    if (curentVersion1 == null || oldVersion2 == null) {
	        throw new Exception("compareVersion error:illegal params.");
	    }
	    String[] versionArray1 = curentVersion1.split("\\.");//注意此处为正则匹配，不能用.；
	    String[] versionArray2 = oldVersion2.split("\\.");
	    int idx = 0;
	    int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值
	    int diff = 0;
	    while (idx < minLength
	            && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度
	            && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符
	    	++idx;
	    }
	    //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
	    diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
	    return diff;
	}
	/**
	 * 强制更新 类型 转换 
	 * @param constrain
	 * @return
	 */
	public static boolean getConstraintValue(String constrain) {
		try {
			return Boolean.valueOf(constrain);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static void main(String[] args) throws Exception {
		
		System.out.println(compareVersion("2.1.7.1","2.1.7.3"));
	}
}
