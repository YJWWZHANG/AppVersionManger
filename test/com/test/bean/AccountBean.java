package com.test.bean;


public class AccountBean {
	 public String address;
	 public String name;
	 public int id;
	 public String email;
	 
	
	@Override
	public String toString() {
		return "AccountBean [address=" + address + ", email=" + email + ", id="
				+ id + ", name=" + name + "]";
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 
}
