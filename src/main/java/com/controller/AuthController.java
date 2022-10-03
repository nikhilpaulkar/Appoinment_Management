package com.controller;

import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ServiceImpl.AuthServiceImpl;
import com.ServiceImpl.UserServiceImpl;
import com.ServiceInterface.LoggerServiceInterface;

import com.dto.ErrorResponseDto;
import com.dto.LoggerDto;
import com.dto.SucessResponseDto;
import com.dto.TokenKeys;
import com.dto.UserDto;
import com.entity.Users;
import com.repository.UserRepository;
import com.utility.PasswordValidator;
import com.webSecurity.JwtAuthRequest;

import com.webSecurity.JwtTokenUtil;



@RestController
@Component
public class AuthController 
{
 
  @Autowired
  private UserServiceImpl userServiceImpl;
	
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private AuthServiceImpl authServiceImpl;
  
  @Autowired
  private JwtTokenUtil jwtTokenUtil;
  
  @Autowired
  private LoggerServiceInterface loggerServiceInterface;
  
  
  
   // register API
   @PostMapping("/register")
   public ResponseEntity<?>createUser(@RequestBody UserDto userDto )throws Exception	
   {
	   String email=userDto.getEmail();
	   //String password=userDto.getPassword();
	if(PasswordValidator.isValidforEmail(email))
    {
	 Users user=this.userRepository.findByEmail(userDto.getEmail());
		 if(user!=null)
		 {
			 return new ResponseEntity<>("user already register ",HttpStatus.NOT_ACCEPTABLE);
		 }
		 else
		 {
		  
		  this.userServiceImpl.creatUser(userDto);
		  return new ResponseEntity<>("Register succesfully",HttpStatus.ACCEPTED);
		 }
	   }
     	else
	  {
		return new ResponseEntity<>("email is not valid",HttpStatus.BAD_REQUEST);
	
	  }
	
	}   
   
   // login API
   @PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthRequest authenticationRequest)
	throws Exception 
    {

		try 
		{
            Users user = userServiceImpl.FindByEmail(authenticationRequest.getEmail());
			
			
			if (authServiceImpl.comaparePassword(user.getPassword(), authenticationRequest.getPassword()));
			{
				
			    String token = jwtTokenUtil.generateToken(user);
			    LoggerDto logger = new LoggerDto();
				logger.setToken(token);
				Calendar calender = Calendar.getInstance();
				calender.add(Calendar.HOUR_OF_DAY, 5);
				logger.setExpiredAt(calender.getTime());
				loggerServiceInterface.createLogger(logger, user);
				return ResponseEntity.ok(new SucessResponseDto("Login successfully", "success", new TokenKeys(user.getId(),user.getName(),user.getEmail(), token)));
				
			}
			
		} catch (BadCredentialsException e) 
		{
			
			throw new Exception("invalid email or password");
			
		} catch (Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "user not found "), HttpStatus.NOT_FOUND);
		}

	}
   

   
}			

