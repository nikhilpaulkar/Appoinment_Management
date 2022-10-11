package com.dto;



import java.util.Date;
import java.util.List;


public class AppointmentDto 
{

	
	private String description;
	private Long managerid;
	private Date createdat;
    private List<Long>  developerid;


   

	
	
	
	public List<Long> getDeveloperid() {
		return developerid;
	}
	public void setDeveloperid(List<Long> developerid) {
		this.developerid = developerid;
	}
	public Date getCreatedat() {
		return createdat;
	}
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
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
	
	
	
	
	public AppointmentDto(String description, Long managerid, Date createdat, List<Long> developerid) {
		super();
		this.description = description;
		this.managerid = managerid;
		this.createdat = createdat;
		this.developerid = developerid;
	}
	public AppointmentDto() 
	{
		super();
		
	}
	
	
}
