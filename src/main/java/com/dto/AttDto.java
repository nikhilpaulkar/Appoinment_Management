package com.dto;

public class AttDto
{
	  private int developerid;
	  private String description;
	  
	  
	public int getDeveloperid() {
		return developerid;
	}
	public void setDeveloperid(int developerid) {
		this.developerid = developerid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AttDto(int developerid, String description) {
		super();
		this.developerid = developerid;
		this.description = description;
	}
	public AttDto() {
		super();
		// TODO Auto-generated constructor stub
	}
   
	
	
}
