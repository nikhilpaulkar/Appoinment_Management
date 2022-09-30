package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceInterface.AttendessServiceInterface;
import com.dto.AttendessDto;
import com.dto.ErrorResponseDto;
import com.entity.Appointment;

@RestController
@RequestMapping("/attendess")
public class AttendessController 
{
	@Autowired
	private AttendessServiceInterface attendessServiceInterface;
	
	
	// update status by developer
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStatusByDeveloper(@PathVariable Integer appointmentid, @RequestBody AttendessDto attendeesDto )
	{
       try 
		{
			this.attendessServiceInterface.updateStatus(attendeesDto, appointmentid);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "user not found"),HttpStatus.BAD_REQUEST);

		}
	}

}
