package com.dto;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Attendess;

public class AppointmentDto 
{

	
	private String description;
	private Long managerid;
	private List<Attendess> attendees;
    private Date createdat;
    private Long developerid;


   

	
	public Long getDeveloperid() {
		return developerid;
	}
	public void setDeveloperid(Long developerid) {
		this.developerid = developerid;
	}
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
	
    
	
    
	public Long getManagerid() {
		return managerid;
	}
	public void setManagerid(Long managerid) {
		this.managerid = managerid;
	}
	
	
	public AppointmentDto(String description, Long managerid, List<Attendess> attendees, Date createdat,
			Long developerid) {
		super();
		this.description = description;
		this.managerid = managerid;
		this.attendees = attendees;
		this.createdat = createdat;
		this.developerid = developerid;
	}
	public AppointmentDto() 
	{
		super();
		
	}
	
	
}
