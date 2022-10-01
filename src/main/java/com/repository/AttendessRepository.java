package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.entity.Attendess;
@Repository
public interface AttendessRepository extends JpaRepository<Attendess, Integer>
{


	
	
}
