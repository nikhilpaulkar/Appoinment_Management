package com.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//@Embeddable
//public class UserRoleId implements  Serializable
//{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	
//    private User user;
//	private RoleEntity role;
//	@ManyToOne
//	@JsonManagedReference
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
//	
//	@ManyToOne
//	@JsonManagedReference
//	public RoleEntity getRole() {
//		return role;
//	}
//	public void setRole(RoleEntity role) {
//		this.role = role;
//	}
//	public UserRoleId(User user, RoleEntity role) {
//		super();
//		this.user = user;
//		this.role = role;
//	}
//	public UserRoleId() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//}
