package com.test;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.test.bean.AccountBean;

public class JsonToJavaBean {
 public static void main(String[] args) {
	 
	 String json = "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}";
	    try {
	    	 ObjectMapper objectMapper = new ObjectMapper();
	        AccountBean acc = objectMapper.readValue(json, AccountBean.class);
	        System.out.println(acc.getName());
	        System.out.println(acc);
	    } catch (JsonParseException e) {
	        e.printStackTrace();
	    } catch (JsonMappingException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
}
 
}
