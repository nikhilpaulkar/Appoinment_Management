package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceInterface.AppoinmentServiceInterface;
import com.dto.AppointmentDto;
import com.dto.ErrorResponseDto;

import com.dto.SucessResponseDto;
import com.entity.Appointment;
import com.exception.ResourceNotFoundException;

import com.webSecurity.JwtTokenUtil;

@RestController
@RequestMapping("/appointment")

public class AppoinmentController 
{
	@Autowired
	private AppoinmentServiceInterface appoinmentServiceInterface;
	
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	// create appointment
	@PostMapping()
	public ResponseEntity<?>addAppointment(@RequestBody AppointmentDto appointmentDto,HttpServletRequest request)
	{
		

		this.appoinmentServiceInterface.createappointment(appointmentDto, request);
        return new ResponseEntity<>(new SucessResponseDto("appointment ","create appointment successfully ","success"), HttpStatus.CREATED);

	}

		
	// get appointment 
	@GetMapping("/{all}")
	public ResponseEntity<List<Appointment>> getAppointmentByManagerId(
			@RequestParam (defaultValue = "1") String pageNumber, 
			@RequestParam(defaultValue = "5") String pageSize,
			@RequestHeader("Authorization") String token)
	{
	  String temp = token.split(" ")[1];
	  String name = jwtTokenUtil.extractName(temp);
	  return new ResponseEntity<List<Appointment>>(appoinmentServiceInterface.findManagerAppointment(pageNumber, pageSize,name),HttpStatus.OK);
	}
	
	// delete appointment by id
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteAppointment(@PathVariable Integer id,HttpServletRequest request)
	{
		try
		{
			this.appoinmentServiceInterface.deleteAppointment(id,request);
			return new ResponseEntity<>(new SucessResponseDto("success","success","delete successfully"),HttpStatus.ACCEPTED);
		}catch(ResourceNotFoundException e)
		{
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(),"appointment not found"),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
