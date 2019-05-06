package com.mobile.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Decoder;

public class MobileUtil {
	/**
	 * 处理字符串空指针
	 * 
	 * @param s
	 *            字符串
	 */
	public String varFormat(String s) {
		if (s == null) {
			s = "";
		}
		return s;
	}
	
	public 	static String varFormatNull(String s) {
		if (s == null) {
			s = "";
		}
		return s;
	}
	
	/**
	 * base64解密
	 * @param str
	 * @return
	 */
	public static String BASE64decode(String str){
		try {
			BASE64Decoder b64decoder = new BASE64Decoder();
			byte []afterStr = b64decoder.decodeBuffer(str);
			return new String(afterStr);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 1.防止空指针 2.解密base64 3.再utf-8 解码
	 * @return
	 * @author fengjunming_t
	 */
	public static String getBaseUTF8Nulldecode(String strs){
		if (strs == null) {
			strs= "";
		}
		return  decode(BASE64decode(strs));
	}
	
	/**
	 * 处理字符串空指针并且 utf-8解码 
	 * 
	 * @param s
	 *            字符串
	 */
	public static String varFormatNulldecode(String s) {
		return s==null?"":decode(s);
	}
	/**
	    * 字符串编码方法
	    * @param s 要编码的字符串
	    * @param enc 所支持的字符编码名称
	    * @return 返回编码后的字符串，如果不支持制定的字符编码则返回原字符串
	    */
	   public static String encode(String s, String enc) {
	       if (null==s || 0==s.length()) {
	           return "";
	       }
	       try {
	           s = URLEncoder.encode(s, enc);
	       }
	       catch (Exception e) {
	       }
	       return s;
	   }

	   /**
	    * 字符串解码方法
	    * @param s 要解码的字符串
	    * @param enc 所支持的字符编码名称
	    * @return 返回解码后的字符串，如果不支持制定的字符编码则返回原字符串
	    */
	   public static String decode(String s, String enc) {
	       if (null==s || 0==s.length()) {
	           return "";
	       }
	       try {
	           s = URLDecoder.decode(s, enc);
	       }
	       catch (Exception e) {
	       }
	       return s;
	   }
	/**
	    * 编码成UTF方法
	    * @param s 字符串
	    * @return 返回符合UTF编码格式的字符串
	    */
	   public static String encode(String s) {
	       return encode(s, "UTF-8");
	   }
	   


	   /**
	    * UTF解码方法
	    * @param s 字符串
	    * @return 返回经过UTF解码的字符串
	    */
	   public static String decode(String s) {
	       return decode(s, "UTF-8");
	   }
	   
	    public static String xmlFormat(String s, String c) {
	        if (null==s || 0==s.length()) {
	            return "";
	        }
	        if (null==c || 0==c.length()) {
	            return s;
	        }
	        //注意对&的处理一定要放在第一个，以防止编码中的&被转换
	        if (c.indexOf("&") != -1) {
	            s = s.replaceAll("&", "&amp;");
	        }
	        if (c.indexOf("<") != -1) {
	            s = s.replaceAll("<", "&lt;");
	        }
	        if (c.indexOf(">") != -1) {
	            s = s.replaceAll(">", "&gt;");
	        }
	        if (c.indexOf("\"") != -1) {
	            s = s.replaceAll("\"", "&quot;");
	        }
	        if (c.indexOf("'") != -1) {
	            s = s.replaceAll("'", "&#39;");
	        }
	        if (c.indexOf(" ") != -1) {
	            s = s.replaceAll(" ", "&nbsp;");
	        }
	        return s;
	    }
	   
	    /**
	     * 处理字符串符合XML格式
	     * @param s 字符串
	     * @return 返回符合XML格式的字符串
	     */
	    public static String xmlFormat(String s) {
	        return xmlFormat(s, "<'&\">");
	    }
	   
		/**
	    * 编码成GBK方法
	    * @param s 字符串
	    * @return 返回符合UTF编码格式的字符串
	    */
	   public static String encodeGBK(String s) {
	       return encode(s, "GBK");
	   }
	   

	   /**
	    * UTF解码方法
	    * @param s 字符串
	    * @return 返回经过UTF解码的字符串
	    */
	   public static String decodeGBK(String s) {
	       return decode(s, "GBK");
	   }
	   
	   
	   /**
	    * 得到几天前的时间
	    * @param d
	    * @param day
	    * @return
	    */
	   public static Date getDateBefore(Date d,int day){
	    Calendar now =Calendar.getInstance();
	    now.setTime(d);
	    now.set(Calendar.DATE,now.get(Calendar.DATE)-day);
	    return now.getTime();
	   }
	   
	   /**
	    * 得到几天后的时间
	    * @param d
	    * @param day
	    * @return
	    */
	   public static Date getDateAfter(Date d,int day){
	    Calendar now =Calendar.getInstance();
	    now.setTime(d);
	    now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
	    return now.getTime();
	   }
	   /**
		 * 按指定格式获得当前日期字符串
		 * 
		 * @param format
		 *            格式字符串yyyy-MM-dd HH:mm:ss
		 */
		public String getDate(String format) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}

		/**
		 * 按指定格式获得指定日期字符串
		 * 
		 * @param format
		 *            格式字符串
		 * @param date
		 *            指定日期
		 */
		public String getDate(String format, Date date) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			String fdate = sdf.format(date);
			return sdf.format(date);
		}
		
		   public static String wmlStringFormat(String s) {
		       if (null==s || 0==s.length()) {
		           return "";
		       }
		       return s.replaceAll(String.valueOf('\u0000'),"").replaceAll("\\$", "＄");
		   }

public static void main(String[] args) {
	MobileUtil ut = new MobileUtil();
	System.out.println(MobileUtil.getDateAfter(new Date(), 7));
	String dateDir = ut.getDate("yyyy")+"/"+ut.getDate("MM")+"/"+ut.getDate("dd")+"/";
	System.out.println(dateDir);
	
}

/**
 * 获取请求浏览器当前ip地址
 * @param httpservletrequest
 * @return
 */
public static String getClientIP(HttpServletRequest httpservletrequest) { 
    if (httpservletrequest == null) 
        return null; 
    String s = httpservletrequest.getHeader("X-Forwarded-For"); 
    if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s)) 
        s = httpservletrequest.getHeader("Proxy-Client-IP"); 
    if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s)) 
        s = httpservletrequest.getHeader("WL-Proxy-Client-IP"); 
    if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s)) 
        s = httpservletrequest.getHeader("HTTP_CLIENT_IP"); 
    if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s)) 
        s = httpservletrequest.getHeader("HTTP_X_FORWARDED_FOR"); 
    if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s)) 
        s = httpservletrequest.getRemoteAddr(); 
    if ("127.0.0.1".equals(s) || "0:0:0:0:0:0:0:1".equals(s)) 
        try { 
            s = InetAddress.getLocalHost().getHostAddress(); 
        } 
        catch (UnknownHostException unknownhostexception) { 
        } 
    return s; 
}


}
