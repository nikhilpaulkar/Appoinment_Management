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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="appointment")
@Where(clause="isactive=true")
@SQLDelete(sql="UPDATE appointment SET isactive=false WHERE id=?")
public class Appointment 
{ 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int managerid;
	@CreationTimestamp
	private Date createdat;
	private String description;
	
	private boolean isactive=true;
	
	@ManyToMany(targetEntity = Attendess.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
	@JsonBackReference
	private List<Attendess> attendees;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Users developerid;
	
	
	
	public Users getDeveloperid() {
		return developerid;
	}
	public void setDeveloperid(Users developerid) {
		this.developerid = developerid;
	}
	public List<Attendess> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<Attendess> attendees) {
		this.attendees = attendees;
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
	
	
	
	public Appointment(int id, int managerid, Date createdat, String description, boolean isactive,
			List<Attendess> attendees, Users developerid) {
		super();
		this.id = id;
		this.managerid = managerid;
		this.createdat = createdat;
		this.description = description;
		this.isactive = isactive;
		this.attendees = attendees;
		this.developerid = developerid;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
