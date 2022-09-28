package com.dto;

import java.util.Date;
import java.util.List;

import com.entity.Attendess;

public class AppointmentDto 
{
	private int id;
	private String description;
	private int managerid;
	private Date createdat;
	private List<Attendess> attendees;



    
	
	
	public List<Attendess> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<Attendess> attendees) {
		this.attendees = attendees;
	}
	public Date getCreatedat() {
		return createdat;
	}
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public AppointmentDto(int id, String description, int managerid, Date createdat, List<Attendess> attendees) {
		super();
		this.id = id;
		this.description = description;
		this.managerid = managerid;
		this.createdat = createdat;
		this.attendees = attendees;
	}
	public AppointmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
