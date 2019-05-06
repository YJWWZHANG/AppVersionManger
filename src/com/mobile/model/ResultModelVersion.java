package com.mobile.model;


import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * app 版本更新返回的josn 对象 
 * @author fengjunming_t
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResultModelVersion {

	private String update;// 更新标识
	private String new_version;// 新版本
	private String apk_url;// 新版apk下载页面页面地址
	private String apk_file_url;// apk下载地址
	private String update_log;// 更新提示结束
	private String target_size;// 目标 大小
	private boolean constraint;//强制  更新
	public static String SUCCESS="success";
	private String status = SUCCESS ;
	private String msg = "ok";
	private Long timestamp=new Date().getTime();

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getNew_version() {
		return new_version;
	}

	public void setNew_version(String newVersion) {
		new_version = newVersion;
	}

	public String getApk_url() {
		return apk_url;
	}

	public void setApk_url(String apkUrl) {
		apk_url = apkUrl;
	}

	public String getApk_file_url() {
		return apk_file_url;
	}

	public void setApk_file_url(String apkFileUrl) {
		apk_file_url = apkFileUrl;
	}

	public String getUpdate_log() {
		return update_log;
	}

	public void setUpdate_log(String updateLog) {
		update_log = updateLog;
	}

	public String getTarget_size() {
		return target_size;
	}

	public void setTarget_size(String targetSize) {
		target_size = targetSize;
	}

	public boolean isConstraint() {
		return constraint;
	}

	public void setConstraint(boolean constraint) {
		this.constraint = constraint;
	}

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

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	

}

