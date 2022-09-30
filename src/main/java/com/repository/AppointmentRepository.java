package com.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Appointment;
import com.entity.Attendess;

@Repository

public interface AppointmentRepository extends JpaRepository<Appointment,Integer>
{
	// get appointment with date wise
	@Query(value= "SELECT * FROM Appointment ORDER BY time ASC", nativeQuery=true)
	List<Appointment> findAllByOrderByTimeAsc(String name);

	

	
	
	//List<Appointment> findByOrderByManagerId(Pageable pagable, Class<Appointment> class1);

	
	

	
}
