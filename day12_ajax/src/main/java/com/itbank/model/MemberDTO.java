package com.itbank.model;

import java.sql.Date;

//	IDX      NOT NULL NUMBER        
//	USERID   NOT NULL VARCHAR2(100) 
//	USERPW   NOT NULL VARCHAR2(255) 
//	USERNAME NOT NULL VARCHAR2(100) 
//	BIRTH    NOT NULL DATE          
//	GENDER   NOT NULL VARCHAR2(10)  

public class MemberDTO {
	
	private int idx;
	private String userid;
	private String userpw;
	private String username;
	private Date birth;
	private String gender;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
