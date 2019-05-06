package com.mobile.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DES {
	private static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8 };
	//加密
	public static String encryptDES(String encryptString, String encryptKey)
			throws Exception {
		BASE64Encoder base64en = new BASE64Encoder();
		IvParameterSpec zeroIv = new IvParameterSpec(iv);
		SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
		byte[] encryptedData = cipher.doFinal(encryptString.getBytes("UTF-8"));
		return base64en.encode(encryptedData);
	}
	//解密
	public static String decryptDES(String decryptString, String decryptKey)
			throws Exception {
		BASE64Decoder base64De = new BASE64Decoder();
		byte[] byteMi = base64De.decodeBuffer(decryptString);
		IvParameterSpec zeroIv = new IvParameterSpec(iv);
		SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
		byte decryptedData[] = cipher.doFinal(byteMi);
		return new String(decryptedData);

	}


}