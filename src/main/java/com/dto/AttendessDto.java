package com.dto;

public class AttendessDto 
{
  private int developerid;
  private String status;

	public int getDeveloperid() {
		return developerid;
	}

	public void setDeveloperid(int developerid) {
		this.developerid = developerid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AttendessDto(int developerid, String status) {
		super();
		this.developerid = developerid;
		this.status = status;
	}

	public AttendessDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
