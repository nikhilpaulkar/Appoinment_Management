package com.payload;

public class UserRoleRequest {
	private int userid;
	private int roleid;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public UserRoleRequest(int userid, int roleid) {
		super();
		this.userid = userid;
		this.roleid = roleid;
	}

	public UserRoleRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
