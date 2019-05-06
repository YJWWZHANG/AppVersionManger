package com.page;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



public class Page {
  public static void main(String[] args) {
	  
	//规定返回日期格式
	  SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
	  Calendar calendar=Calendar.getInstance();
	  Date theDate=calendar.getTime();
	  GregorianCalendar gcLast=(GregorianCalendar)Calendar.getInstance();
	  gcLast.setTime(theDate);
	  //设置为第一天
	  gcLast.set(Calendar.DAY_OF_MONTH, 3);
	  String day_first=sf.format(gcLast.getTime());
	  //打印本月第一天
	  System.out.println(day_first);
}
}
