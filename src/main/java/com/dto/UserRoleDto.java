package com.dto;

public class UserRoleDto 
{
	private int roleid;
    private String userid;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public UserRoleDto(int roleid, String userid) {
		super();
		this.roleid = roleid;
		this.userid = userid;
	}
	public UserRoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
