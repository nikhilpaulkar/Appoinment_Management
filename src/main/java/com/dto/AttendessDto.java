package com.dto;

public class AttendessDto 
{
  private int attendeesid;
  private int developerid;
  private boolean status;

  public int getAttendeesid() 
  {
	return attendeesid;
  }

   public void setAttendeesid(int attendeesid) {
	this.attendeesid = attendeesid;
  }

  public int getDeveloperid() {
	return developerid;
  }


   public void setDeveloperid(int developerid) {
	this.developerid = developerid;
  }

  public boolean isStatus() {
	return status;
  }

  public void setStatus(boolean status) {
	this.status = status;
  }

  

	public AttendessDto(int attendeesid, int developerid, boolean status) 
	{
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
