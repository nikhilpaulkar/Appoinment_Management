package com.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ServiceInterface.AuthInterface;
import com.dto.UserDto;
import com.entity.User;
import com.repository.AuthRepository;

@Service
public class AuthServiceImpl implements AuthInterface
{
	@Autowired
	private AuthRepository authrepository;

	//@Autowired
	private PasswordEncoder passwordencoder;

	@Override
	public UserDetails loasUserByUsername(String email)throws UsernameNotFoundException
	{

		User user;
		user = authrepository.findByEmail(email);
		if (user == null)
		{  
		throw new UsernameNotFoundException("User not found with Email: " + email);
		}
             return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),new ArrayList<>());
		}

	    @Override
	   public boolean comaparePassword(String email, String hashpassword)
	  {
		return passwordencoder.matches(hashpassword, hashpassword);
	  }

		
}
