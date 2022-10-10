package com.repository;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ServiceInterface.IAppointmentDto;

import com.entity.Appointment;

import io.lettuce.core.dynamic.annotation.Param;


@Repository

public interface AppointmentRepository extends JpaRepository<Appointment,Long>
{
	
	
	@Query(value= "SELECT * FROM Appointment ORDER BY createdat ASC", nativeQuery=true)

	Page<IAppointmentDto> findByCreatedAtByAsc(String search, Pageable pagable, Class<IAppointmentDto> class1);
	Page<IAppointmentDto> findByOrderById(Pageable pagable, Class<IAppointmentDto> class1);
	
	
	@Transactional
	@Query(value = "select * from Appointment a where a.managerid=:managerid",nativeQuery = true)
	Optional<Appointment> findByManagerId(@Param("managerid")  Long managerid);
	
	
	

}
