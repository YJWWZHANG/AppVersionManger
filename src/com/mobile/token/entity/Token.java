package com.mobile.token.entity;

import java.util.Date;
import java.util.UUID;

import com.mobile.util.IDGenerator;

/**
 * 口令表 mobile_token
 * 
 * @author fengjunming_t
 * 
 */
public class Token {
	public String id;
	public String username;
	public String password;
	public Date validtime;// 过期 时间
	public String tokenid;
	public int islock;
	public int isbomb;
	public Date updatetime;
	public String device;

	public String getId() {
		return UUID.randomUUID().toString();//随机数作为 主键id值 
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getValidtime() {
		return validtime;
	}

	public void setValidtime(Date validtime) {
		this.validtime = validtime;
	}

	public String getTokenid() {
		return tokenid;//生成 32为的字符口令 
	}

	public void setTokenid(String tokenid) {
		this.tokenid = tokenid;
	}

	public int getIslock() {
		return islock;
	}

	public void setIslock(int islock) {
		this.islock = islock;
	}

	public int getIsbomb() {
		return isbomb;
	}

	public void setIsbomb(int isbomb) {
		this.isbomb = isbomb;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

}
