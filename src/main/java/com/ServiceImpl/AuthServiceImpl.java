package com.ServiceImpl;


import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ServiceInterface.AuthInterface;
import com.config.CacheOperation;
import com.entity.Users;
import com.repository.AuthRepository;

@Service
public class AuthServiceImpl implements AuthInterface
{
	@Autowired
	private AuthRepository authRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CacheOperation cache;

	 @Override
	 public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException  
	  {
		Users user;
		if (!cache.isKeyExist(email,email))
		{
            
			user = authRepository.findByEmail(email);
			System.out.println("Database");
			cache.addInCache(email, email, user);

		} 	
		else
		{

			user = (Users) cache.getFromCache(email, email); 
			System.out.println("Cache");
			
		}

		//
		//user = authRepository.findByEmail(email);
		if (user == null)
		{
			throw new UsernameNotFoundException("User not found with Email: " + email);
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),new ArrayList<>());
	    }
	
	



		@Override
	   public boolean comaparePassword(String email, String hashpassword)
	  {
		return passwordEncoder.matches(hashpassword, hashpassword);
	  }





		public AuthServiceImpl() {
			super();
			// TODO Auto-generated constructor stub
		}

	
		
}
