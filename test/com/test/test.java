package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test {
	  private static String path = "E:\\Temp\\userInfoImage\\appFile\\nmyd.ipa";    
      public  static void FileContent() throws IOException     
      {    
//          File f = new File(path);    
//          FileReader fileReader = new FileReader(f);    
//          BufferedReader br = new BufferedReader(fileReader);    
//          String str;    
//          while((str = br.readLine() ) != null)    
//          {    
//              System.out.println(str);    
//          }    
          System.out.println(new FileInputStream(new File(path)).available() / 1024 / 1024 +"M");  
      }
      public static void main(String[] args) {    
    	  int s;
		try {
			s = daysBetween("2","4");
			System.out.println(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
      } 
      
      
      public static int daysBetween(String smdate,String bdate) throws ParseException{  
          SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
          Calendar cal = Calendar.getInstance();    
          cal.setTime(sdf.parse(smdate));    
          long time1 = cal.getTimeInMillis();                 
          cal.setTime(sdf.parse(bdate));    
          long time2 = cal.getTimeInMillis();         
          long between_days=(time2-time1)/(1000*3600*24);  
              
         return Integer.parseInt(String.valueOf(between_days));     
      }  
}
