package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceInterface.AppoinmentServiceInterface;
import com.dto.AppointmentDto;
import com.dto.ErrorResponseDto;

import com.dto.SucessResponseDto;
import com.entity.Appointment;

import com.repository.AppointmentRepository;
import com.repository.UserRepository;
import com.webSecurity.JwtTokenUtil;

@RestController
@RequestMapping("/appointment")

public class AppoinmentController 
{
	@Autowired
	private AppoinmentServiceInterface appoinmentServiceInterface;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	// create appointment
	//@PreAuthorize("hasrole('posturi')")
	@PostMapping()
	public ResponseEntity<?>addAppointment(@RequestBody AppointmentDto appointmentDto,HttpServletRequest request)
	{
		

		Appointment appointment= this.appoinmentServiceInterface.createappointment(appointmentDto, request);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);

	}

		
	// get appointment 
	@GetMapping("/{all}")
    public ResponseEntity<List<Appointment>> getAppointmentByManagerId(@RequestHeader("Authorization") String token)
	{

	 String temp = token.split(" ")[1];
     String name = jwtTokenUtil.extractName(temp);
	 return new ResponseEntity<List<Appointment>>(appointmentRepository.findAllByOrderByTimeAsc(name),HttpStatus.OK);

    }

	
	
	// delete appointment by id
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteAppointment(@PathVariable Integer id)
	{
		try
		{
			this.appoinmentServiceInterface.deleteAppointment(id);
			return new ResponseEntity<>(new SucessResponseDto("success","success","delete successfully"),HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(),"appointment not found"),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
