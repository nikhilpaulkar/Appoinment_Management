package com.entity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
@Entity
@Table(name="attendance")

public class Attendess 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int developerid;
	private String status;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Attendess(int id, int developerid, String status) {
		super();
		this.id = id;
		this.developerid = developerid;
		this.status = status;
	}
	public Attendess() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


   
}
