package com.ServiceImpl;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ServiceInterface.AuthInterface;

import com.entity.Users;
import com.repository.AuthRepository;

@Service
public class AuthServiceImpl implements AuthInterface
{
	@Autowired
	private AuthRepository authRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	 @Override
	 public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException  
	  {
		Users user;
		user = authRepository.findByEmail(email);
		if (user == null)
		{
			throw new UsernameNotFoundException("User not found with Email: " + email);
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),getAuthority(user));
	   }
	
	

	  private Collection<? extends GrantedAuthority> getAuthority(Users user)
	  {
		
		return null;
	  }



		@Override
	   public boolean comaparePassword(String email, String hashpassword)
	  {
		return passwordEncoder.matches(hashpassword, hashpassword);
	  }

	
		
}
