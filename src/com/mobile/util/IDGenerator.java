package com.mobile.util;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class IDGenerator {
	public static String generateID1() {
		String rtnVal = Long.toHexString(System.currentTimeMillis());
		rtnVal = rtnVal + UUID.randomUUID();
		rtnVal = rtnVal.replaceAll("-", "");
		return rtnVal.substring(0, 32);
	}

	public static String generateID(Date date) {
		String rtnVal = Long.toHexString(date.getTime());
		rtnVal = rtnVal + UUID.randomUUID();
		rtnVal = rtnVal.replaceAll("-", "");
		return rtnVal.substring(0, 32);
	}

	private static int nextInt(int paramInt1, int paramInt2, long paramLong) {
		if (paramInt2 <= paramInt1)
			return 0;
		int i = 0;
		Random localRandom = new Random();
		localRandom.setSeed(paramLong);
		i = paramInt1 + localRandom.nextInt(paramInt2);
		return i;
	}

	public static String generateID() {
		Date localDate = new Date();
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(
				"yyyyMMddHHmmss");
		String str1 = localSimpleDateFormat.format(localDate);
		SecureRandom localSecureRandom = new SecureRandom();
		String str2 = "";
		try {
			String str3 = String.valueOf(nextInt(100000, 899999,
					localSecureRandom.nextInt(100000000)));
			str2 = str1 + str3;
		} catch (Exception localException) {
			System.out.println(localException.getMessage());
		}
		return str2;
	}

	private static void printIDTime(String id) {
		String timeInfo = id.substring(0, 11);
		System.out.println(new Date(Long.parseLong(timeInfo, 16)));
	}

	public static String RandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < length; i++) {
			int num = random.nextInt(36);
			buf.append(str.charAt(num));
		}

		return buf.toString();
	}

	public static Date getIDCreateTime(String id) {
		String timeInfo = id.substring(0, 11);
		return new Date(Long.parseLong(timeInfo, 16));
	}
	public static void main(String[] args) {
		System.out.println(IDGenerator.RandomString(16));
	}

}
