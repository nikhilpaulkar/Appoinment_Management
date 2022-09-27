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
   private int blockedByUserId;
   private int blockUserId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBlockedByUserId() {
		return blockedByUserId;
	}

	public void setBlockedByUserId(int blockedByUserId) {
		this.blockedByUserId = blockedByUserId;
	}

	
	public int getBlockUserId() {
		return blockUserId;
	}

	public void setBlockUserId(int blockUserId) {
		this.blockUserId = blockUserId;
	}
    
	
	
	public BlockList(int id, int blockedByUserId, int blockUserId) {
		super();
		this.id = id;
		this.blockedByUserId = blockedByUserId;
		this.blockUserId = blockUserId;
	}

	public BlockList() {
		super();
		// TODO Auto-generated constructor stub
	}
   
	
}
