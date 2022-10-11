package com.dto;

import java.util.ArrayList;

public class AttendessDto 
{
 
  private ArrayList<Long> developerid;
  private boolean status;

  

  public ArrayList<Long> getDeveloperid() {
	return developerid;
}

  public void setDeveloperid(ArrayList<Long> developerid) {
	this.developerid = developerid;
}


  public boolean isStatus() {
	return status;
}


  public void setStatus(boolean status) {
	this.status = status;
}


	public AttendessDto(ArrayList<Long> developerid, boolean status) {
	super();
	this.developerid = developerid;
	this.status = status;
}

	public AttendessDto() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	
}
