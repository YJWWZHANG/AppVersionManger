package com.mobile.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64EncoderUtil {

	/**
	 * 加密方法
	 * @param str
	 * @return
	 */
	public static String encode(String str){
			return new BASE64Encoder().encode(str.getBytes());
		
	}
	/**
	 * BASE64Decoder 解密码方法 
	 * @param str
	 * @return
	 */
	public static String decode(String str){
		try {
			BASE64Decoder b64decoder = new BASE64Decoder();
			byte []afterStr = b64decoder.decodeBuffer(str);
			return new String(afterStr);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
