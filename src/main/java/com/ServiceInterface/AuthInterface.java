package com.ServiceInterface;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dto.UserDto;
import com.entity.User;

public interface AuthInterface 
{
	
	User findByEmail(String email);

	void createUser(UserDto userdto);

	boolean comaparePassword(String email, String hashpassword);

	UserDetails loasUserByUsername(String email) throws UsernameNotFoundException;
}
