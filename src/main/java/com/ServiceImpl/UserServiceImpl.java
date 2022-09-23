package com.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ServiceInterface.UserServiceInterface;
import com.dto.UserDto;
import com.entity.User;
import com.exception.ResourceNotFoundException;
import com.repository.UserRepository;
@Service
public class UserServiceImpl implements UserServiceInterface
{
	@Autowired
	private UserRepository userrepository;
//	@Autowired
//	private PasswordEncoder passwordencoder;
//	
	
	//add data
   public void adduser(User user)
   {
	try
	{
		userrepository.save(user);
	}catch(Exception e)
	{
		new ResourceNotFoundException("user already register");
	}
			
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	public UserDetails loadUserByUsername(String email) 
	{
		
		return null;
	}

	

	public void createUser(UserDto userdto) {
		
	}

	
}
