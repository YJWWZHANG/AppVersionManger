package com.mobile.model;


import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mobile.util.ResultCodeUtile;
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ResultModel {

	private String status = ResultCodeUtile.SUCCESS ;//默认是认证成功的 
	private String msg = "ok";
	private int code=200;
	private String errcode;
	private String describe;
	private Long timestamp=new Date().getTime();
	private DataModel data;
	
	//app版本更新返回值
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public DataModel getData() {
		return data;
	}
	public void setData(DataModel data) {
		this.data = data;
	}

	
}

