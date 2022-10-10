package com.dto;

import java.util.ArrayList;

public class AttendessDto 
{
  private Long attendeesid;
  private Long developerid;
  private boolean status;

  

  

  

  public Long getAttendeesid() {
	return attendeesid;
}

public void setAttendeesid(Long attendeesid) {
	this.attendeesid = attendeesid;
}

  
  public Long getDeveloperid() {
	return developerid;
}

public void setDeveloperid(Long developerid) {
	this.developerid = developerid;
}

public boolean isStatus() {
	return status;
  }

  public void setStatus(boolean status) {
	this.status = status;
  }

  

	


	public AttendessDto(Long attendeesid, Long developerid, boolean status) {
	super();
	this.attendeesid = attendeesid;
	this.developerid = developerid;
	this.status = status;
}

	public AttendessDto() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	
}
