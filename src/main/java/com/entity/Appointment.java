package com.entity;


import java.util.Date;
import java.util.List;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@Table(name="appointment")
@Where(clause="isactive=true")
@SQLDelete(sql="UPDATE appointment SET isactive=false WHERE id=?")
public class Appointment 
{ 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long managerid;
	@CreationTimestamp
	private Date createdat;
	private String description;
	
	private boolean isactive=true;
	
	
	
	@OneToMany(mappedBy="appointment")
    private List<Attendess> attendess;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getManagerid() {
		return managerid;
	}
	public void setManagerid(Long managerid) {
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
	
   public List<Attendess> getAttendess() {
		return attendess;
	}
	public void setAttendess(List<Attendess> attendess) {
		this.attendess = attendess;
	}
	
	public Appointment(Long id, Long managerid, Date createdat, String description, boolean isactive,
			List<Attendess> attendess) {
		super();
		this.id = id;
		this.managerid = managerid;
		this.createdat = createdat;
		this.description = description;
		this.isactive = isactive;
		this.attendess = attendess;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
