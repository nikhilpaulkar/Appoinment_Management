package com.dto;


import java.util.Date;
import java.util.List;

import com.entity.Attendess;

public class AppointmentDto 
{

	
	private String description;
	private int managerid;
	private List<Attendess> attendees;
    private Date createdat;


    
    public Date getCreatedat() {
		return createdat;
	}
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	public List<Attendess> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<Attendess> attendees) {
		this.attendees = attendees;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	
    
	public AppointmentDto(String description, int managerid, List<Attendess> attendees, Date createdat) {
		super();
		this.description = description;
		this.managerid = managerid;
		this.attendees = attendees;
		this.createdat = createdat;
	}
	public AppointmentDto() 
	{
		super();
		
	}
	
	
}
