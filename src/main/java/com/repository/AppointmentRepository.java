package com.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Appointment;

@Repository

public interface AppointmentRepository extends JpaRepository<Appointment,Integer>
{
	// get appointment with date wise
	@Query(value= "SELECT * FROM Appointment ORDER BY time ASC", nativeQuery=true)
	List<Appointment> findAllByOrderByTimeAsc(String name);

	
}
