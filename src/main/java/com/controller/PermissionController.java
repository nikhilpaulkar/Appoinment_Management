package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceInterface.PermissionServiceInterface;
import com.dto.ErrorResponseDto;
import com.dto.PermissionDto;

import com.dto.SucessResponseDto;

@RestController
@RequestMapping("/permission")
public class PermissionController 
{
	
   @Autowired
   private PermissionServiceInterface permissionServiceInterface;
   
   // add permission
   @PostMapping()
   public  ResponseEntity<?>addrole(@RequestBody PermissionDto permissionDto)
	{
		try
		{
			permissionServiceInterface.addPermission(permissionDto);
			return new ResponseEntity<>(new SucessResponseDto("success","success","successfully added permission"),HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto( "does not exit  ","permission id does not exit"),HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
