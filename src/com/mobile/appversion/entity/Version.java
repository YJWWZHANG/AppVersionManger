package com.mobile.appversion.entity;

import java.sql.Timestamp;

/**
 *  静态参数常量
	<p>APP唯一值 appKey</p>
	<p>版本更新时间 updateTime</p>
	<p>当前版本号 version</p>
	<p>当前更改状态 state</p>
	<p>应用类型 applicationType</p>
	<p>安装包上传路径 updatePackagePath</p>
	<p>应用名称 appName</p>
	<p>更新提示语 updateLog</p>
	<p>应用文件下载地址或者是文件下载页面地址appUrl</p>
	<p>文件大小targetSize</p>
	<p>强制更新 constraints</p>
 *
 */
public class Version {

	public String appName;

	public String appKey;

	public Timestamp updateTime;

	public String version;
	public String state;
	public String applicationType;
	public String updatePackagePath;
	
	public String updateLog;
	public String appUrl;
	
	public String targetSize;
	
	public String constraints;
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateLog() {
		return updateLog;
	}
	public void setUpdateLog(String updateLog) {
		this.updateLog = updateLog;
	}
	public String getAppUrl() {
		return appUrl==null?"":this.appUrl;
	}
	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	public String getUpdatePackagePath() {
		return updatePackagePath==null?"":this.updatePackagePath;
	}
	public void setUpdatePackagePath(String updatePackagePath) {
		this.updatePackagePath = updatePackagePath;
	}
	public String getTargetSize() {
		return targetSize;
	}
	public void setTargetSize(String targetSize) {
		this.targetSize = targetSize;
	}
	public String getConstraints() {
		return constraints;
	}
	public void setConstraints(String constraints) {
		this.constraints = constraints;
	}
	
	
}
