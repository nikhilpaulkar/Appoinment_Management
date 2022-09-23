package com.dto;

import java.util.Date;

public class LoggerDto 
{
	 private int userid;
	 private String token;
	 private Date expiredAt;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getExpiredAt() {
		return expiredAt;
	}
	public void setExpiredAt(Date expiredAt) {
		this.expiredAt = expiredAt;
	}
	public LoggerDto(int userid, String token, Date expiredAt) {
		super();
		this.userid = userid;
		this.token = token;
		this.expiredAt = expiredAt;
	}
	public LoggerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 

}
