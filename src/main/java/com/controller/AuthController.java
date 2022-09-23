package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceImpl.AuthServiceImpl;
import com.ServiceImpl.UserServiceImpl;
import com.ServiceInterface.AuthInterface;
import com.dto.UserDto;
import com.entity.User;
import com.repository.UserRepository;



@RestController
public class AuthController 
{
  @Autowired
  private AuthInterface authInterfacce;
	
	   // register api
	   @PostMapping("/register")
		
		public ResponseEntity<?> createUser(@RequestBody UserDto userdto) throws Exception 
	    {
	      System.out.println("welcome");
		try 
		{
		  User user=this.authInterfacce.findByEmail(userdto.getEmail());
		  if(user !=null)
		  {
			return new ResponseEntity<>("user already exisits", HttpStatus.NOT_FOUND);
		  }
		  else 
		  {
			 
			this.authInterfacce.createUser(userdto);
			return new ResponseEntity<>("Success", HttpStatus.CREATED);
		  }
		  } catch (Exception e) 
		  {
            return new ResponseEntity<>("hello", HttpStatus.OK);
		  }
		  
	}

}
