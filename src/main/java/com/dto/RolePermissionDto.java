package com.dto;

public class RolePermissionDto {
	private int roleid;
	private int permissionid;

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getPermissionid() {
		return permissionid;
	}

	public void setPermissionid(int permissionid) {
		this.permissionid = permissionid;
	}

	public RolePermissionDto(int roleid, int permissionid) {
		super();
		this.roleid = roleid;
		this.permissionid = permissionid;
	}

	public RolePermissionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
   
	
}
