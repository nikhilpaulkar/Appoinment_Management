package com.entity;
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

@Entity
@Table(name="attendance")

public class Attendess 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int developerid;
	private boolean status;
	
	@ManyToMany(targetEntity = Appointment.class, mappedBy = "attendees", cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})

	private List<Appointment> appointment;



	
	@OneToOne(fetch=FetchType.LAZY)
	private Appointment appointmentid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}
	public Appointment getAppointmentid() {
		return appointmentid;
	}
	public void setAppointmentid(Appointment appointmentid) {
		this.appointmentid = appointmentid;
	}
	
	
	public Attendess(int id, int developerid, boolean status, List<Appointment> appointment,
			Appointment appointmentid) {
		super();
		this.id = id;
		this.developerid = developerid;
		this.status = status;
		this.appointment = appointment;
		this.appointmentid = appointmentid;
	}
	public Attendess() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


   
}
