package com.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="attendance")

public class Attendess 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	private Long developerid;
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name="appointmentid")
    private Appointment appointment;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	
	
	
	public Attendess(Long id, Long developerid, boolean status, Appointment appointment) {
		super();
		this.id = id;
		this.developerid = developerid;
		this.status = status;
		this.appointment = appointment;
	}
	public Attendess() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


   
}
