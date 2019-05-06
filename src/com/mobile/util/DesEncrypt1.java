package com.mobile.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;




public class DesEncrypt1 {
	 /**
	  * 
	  * 使用DEA加密与解密,可对byte[],String类型进行加密与解密 密文可使用String,byte[]存储.
	  * 
	  * 方法: void getKey(String strKey)从strKey的字条生成一个Key
	  * 
	  * String getEncString(String strMing)对strMing进行加密,返回String密文 String
	  * getDesString(String strMi)对strMin进行解密,返回String明文
	  * 
	  *byte[] getEncCode(byte[] byteS)byte[]型的加密 byte[] getDesCode(byte[]
	  * byteD)byte[]型的解密
	  */
	 
	  Key key;
	 
	 /**
	  * 根据参数生成KEY
	  * 
	  * @param strKey
	  */
	 public void getKey(String strKey) {
		 try {  
	            KeyGenerator _generator = KeyGenerator.getInstance("DES");  
	            //防止linux下 随机生成key   
	            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
	            secureRandom.setSeed(strKey.getBytes());  
	              
	            _generator.init(56,secureRandom);  
	            this.key = _generator.generateKey();  
	            _generator = null;  
	        } catch (Exception e) {  
	            throw new RuntimeException(  
	                    "Error initializing SqlMap class. Cause: " + e);  
	        } 
	 }
	 
	 /**
	  * 加密String明文输入,String密文输出
	  * 
	  * @param strMing
	  * @return
	  */
	 public String getEncString(String strMing) {
		
	 
	  byte[] byteMi = null;
	  byte[] byteMing = null;
	  String strMi = "";
	  Base64 base64en = new Base64();
	  try {
	   byteMing = strMing.getBytes("UTF8");
	   byteMi = this.getEncCode(byteMing);
	   strMi = base64en.encode(byteMi);
	  } catch (Exception e) {
	   e.printStackTrace();
	  } finally {
	   base64en = null;
	   byteMing = null;
	   byteMi = null;
	  }
	  return strMi;
	 }
	 
	 /**
	  * 解密 以String密文输入,String明文输出
	  * 
	  * @param strMi
	  * @return
	  */
	 public String getDesString(String strMi) {
		
	  Base64 base64De = new Base64();
	  byte[] byteMing = null;
	  byte[] byteMi = null;
	  String strMing = "";
	  try {
	   byteMi = base64De.decode(strMi);
	   byteMing = this.getDesCode(byteMi);
	   strMing = new String(byteMing, "UTF8");
	  } catch (Exception e) {
	   e.printStackTrace();
	  } finally {
	   base64De = null;
	   byteMing = null;
	   byteMi = null;
	  }
	  return strMing;
	 }
	 
	 /**
	  * 加密以byte[]明文输入,byte[]密文输出
	  * 
	  * @param byteS
	  * @return
	  */
	 public byte[] getEncCode(byte[] byteS) {
	  byte[] byteFina = null;
	  Cipher cipher;
	  try {
	   cipher = Cipher.getInstance("DES");
	   cipher.init(Cipher.ENCRYPT_MODE, key);
	   byteFina = cipher.doFinal(byteS);
	  } catch (Exception e) {
	   e.printStackTrace();
	  } finally {
	   cipher = null;
	  }
	  return byteFina;
	 }
	 
	 /**
	  * 解密以byte[]密文输入,以byte[]明文输出
	  * 
	  * @param byteD
	  * @return
	  */
	 public byte[] getDesCode(byte[] byteD) {
	  Cipher cipher;
	  byte[] byteFina = null;
	  try {
	   cipher = Cipher.getInstance("DES");
	   cipher.init(Cipher.DECRYPT_MODE, key);
	   byteFina = cipher.doFinal(byteD);
	  } catch (Exception e) {
	   e.printStackTrace();
	  } finally {
	   cipher = null;
	  }
	  return byteFina;
	 }
	 /**
	  * 加密
	  * @param strMing
	  * @return
	  */
	 public static String encrypt(String strMing) {
		 DesEncrypt1 d = new DesEncrypt1();
		 d.getKey(Constant.DESKEY);
		 return d.getEncString(strMing);
	 }
	 /**
	  * 解密
	  * @param strMing
	  * @return
	  */
	 public static String decrypt(String strMi) {
		 DesEncrypt1 d = new DesEncrypt1();
		 d.getKey(Constant.DESKEY);
		 return d.getDesString(strMi);
	 }
	 public static void main(String[] args) throws UnsupportedEncodingException {
		 //VVHZZSpx8U4= 
		System.out.println(DesEncrypt1.encrypt("a"));
		System.out.println(URLEncoder.encode("VVHZZSpx8U4="));
		System.out.println(URLDecoder.decode("2015-01-20%20%20%E6%94%B6%E5%B8%82%E4%BB%B7%EF%BC%9A98.15%20%20%E6%9C%80%E9%AB%98%E4%BB%B7%EF%BC%9A98.45%20%20%E6%9C%80%E4%BD%8E%E4%BB%B7%EF%BC%9A96.6%20%20%E6%88%90%E4%BA%A4%E9%87%8F%EF%BC%9A12.37M%20%20%E6%88%90%E4%BA%A4%E9%A2%9D%EF%BC%9A1.21B","UTF-8"));
	}
}