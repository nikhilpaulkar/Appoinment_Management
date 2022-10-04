package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.entity.BlockList;

@Repository
public interface BlockRepository extends JpaRepository<BlockList, Integer>
{

	BlockList findByBlockUser(int managerid);

	
	
	
	
	

   
	
}
