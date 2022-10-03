package com.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="blocklist")
public class BlockList 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private int blockedby;
   private int blockUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBlockedby() {
		return blockedby;
	}

	public void setBlockedby(int blockedby) {
		this.blockedby = blockedby;
	}

	public int getBlockUser() {
		return blockUser;
	}

	public void setBlockUser(int blockUser) {
		this.blockUser = blockUser;
	}

	public BlockList(int id, int blockedby, int blockUser) {
		super();
		this.id = id;
		this.blockedby = blockedby;
		this.blockUser = blockUser;
	}

	public BlockList() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BlockList [id=" + id + ", blockedby=" + blockedby + ", blockUser=" + blockUser + "]";
	}
	
	

}
