package com.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceInterface.AppoinmentServiceInterface;
import com.ServiceInterface.IAppointmentDto;

import com.dto.AppointmentDto;
import com.dto.ErrorResponseDto;

import com.dto.SucessResponseDto;

import com.exception.ResourceNotFoundException;



@RestController
@RequestMapping("/appointment")

public class AppoinmentController 
{
	@Autowired
	private AppoinmentServiceInterface appoinmentServiceInterface;
	
	
	
	// create appointment
	
	@PostMapping()
	public ResponseEntity<?>addAppointment(@RequestBody AppointmentDto appointmentDto,HttpServletRequest request)
	{
		

		this.appoinmentServiceInterface.createappointment(appointmentDto, request);
        return new ResponseEntity<>(new SucessResponseDto("appointment ","create appointment successfully ","success"), HttpStatus.CREATED);

	}

	
		
	// get appointment with pagination
	@GetMapping("/all")
	public ResponseEntity<?> getAllusers(
			@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "5") String pageSize)
	{
		
		Page<IAppointmentDto> entity= appoinmentServiceInterface.getAllAppointment(search,pageNumber,pageSize);
		if(entity.getTotalElements()!=0)
		{
			return new ResponseEntity<>(entity.getContent(), HttpStatus.OK);
		}
		else
		{
		return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
	    }
	}
	
	// delete appointment by id
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteAppointment(@PathVariable Long id,HttpServletRequest request)
	{
		try
		{
			this.appoinmentServiceInterface.deleteAppointment(id,request);
	
			return new ResponseEntity<>(new SucessResponseDto("success","success","delete successfully"),HttpStatus.ACCEPTED);
		}catch( ResourceNotFoundException e)
		{	
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(),"appointment not found"),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
}
