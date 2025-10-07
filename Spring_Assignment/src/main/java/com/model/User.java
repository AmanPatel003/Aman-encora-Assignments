package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	private long uid;
	private String uname,upass;
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(long uid, String uname) {
		super();
		this.uid = uid;
		this.uname = uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	

}
