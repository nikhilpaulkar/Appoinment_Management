package com.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="appointment")
public class Appointment 
{ 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int managerid;
	private Date createdat;
	private String description;
	private String name;
	private boolean isactive=true;
	private int createdbyid ;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="task.appointment",cascade=CascadeType.ALL )
	


    
	public int getCreatedbyid() {
		return createdbyid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCreatedbyid(int createdbyid) {
		this.createdbyid = createdbyid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
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
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
	public Appointment(int id, int managerid, Date createdat, String description, String name, boolean isactive,
			int createdbyid) {
		super();
		this.id = id;
		this.managerid = managerid;
		this.createdat = createdat;
		this.description = description;
		this.name = name;
		this.isactive = isactive;
		this.createdbyid = createdbyid;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
