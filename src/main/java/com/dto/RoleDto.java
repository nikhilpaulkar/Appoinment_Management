package com.dto;

public class RoleDto 
{
	private int id;
	private String roleName;
	
	public int getId() {
		return id;
	}
    public void setId(int id) {
		this.id = id;
	}

    public String getRoleName() {
		return roleName;
	}

   public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
    
   public RoleDto(int id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}



	public RoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	
  
	 


}
