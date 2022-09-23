package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;


import com.fasterxml.jackson.annotation.JsonBackReference;
//@Entity
//@Table(name="role")
//@Where(clause="isactive=true")
//@SQLDelete(sql="UPDATE role SET isactive=false WHERE id=?")
//public class RoleEntity implements Serializable{
//
//	/**
//	 * 
//	 */
//	  private static final long serialVersionUID = 1L;
//	  @Id
//	  @GeneratedValue(strategy = GenerationType.IDENTITY)
//	  private int id;
//	  
//	  private String roleName;
//	  
//	  @UpdateTimestamp
//	  private Date updatedat;
//	  
//	  @CreationTimestamp
//	  private Date createdat;
//	  
//	  private boolean isactive=true;
//	  
//	  @OneToMany(fetch=FetchType.LAZY,mappedBy="task.role",cascade=CascadeType.ALL)
//	  @JsonBackReference
//	  private List<UserRoleEntity> userrole;
//	  
//	  
//	  public int getId() {
//		return id;
//	  }
//	  public void setId(int id) {
//		this.id = id;
//	  }
//	  public String getRoleName() {
//		return roleName;
//	  }
//	  public void setRoleName(String roleName) {
//		this.roleName = roleName;
//	  }
//	  public Date getUpdatedat() {
//		return updatedat;
//	  }
//	  public void setUpdatedat(Date updatedat) {
//		this.updatedat = updatedat;
//	  }
//	  public Date getCreatedat() {
//		return createdat;
//	  }
//	  public void setCreatedat(Date createdat) {
//		this.createdat = createdat;
//	  }
//	  public boolean isIsactive() {
//		return isactive;
//	  }
//	  public void setIsactive(boolean isactive) {
//		this.isactive = isactive;
//	  }
//	  public List<UserRoleEntity> getUserrole() {
//		return userrole;
//	  }
//	  public void setUserrole(List<UserRoleEntity> userrole) {
//		this.userrole = userrole;
//	  }
//	  public RoleEntity(int id, String roleName, Date updatedat, Date createdat, boolean isactive,
//			List<UserRoleEntity> userrole) {
//		super();
//		this.id = id;
//		this.roleName = roleName;
//		this.updatedat = updatedat;
//		this.createdat = createdat;
//		this.isactive = isactive;
//		this.userrole = userrole;
//	  }
//	   public RoleEntity() {
//		super();
//		// TODO Auto-generated constructor stub
//	 }
//      
//	  
//}
