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

import com.dto.SucessResponseDto;


@RestController
@RequestMapping("/attendess")
public class AttendessController 
{
	@Autowired
	private AttendessServiceInterface attendessServiceInterface;
	
	
	// update status by developer
	@PutMapping("/{id}")
	public ResponseEntity<?>updatestatusByDeveloper(@RequestBody AttendessDto attendessDto,@PathVariable Long id)
	{
		try
		{
			
		  this.attendessServiceInterface.updateStatus(attendessDto,id);
		  return new ResponseEntity<>(new SucessResponseDto("update", "update sucessfully", id),HttpStatus.OK);
	
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Please Enter Valid Appointmetnt id OR developer id ..", "Not Updated Data.."),HttpStatus.NOT_FOUND);
		}
			
	}

}
