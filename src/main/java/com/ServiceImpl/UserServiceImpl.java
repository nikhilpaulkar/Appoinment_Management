package com.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ServiceInterface.IUserListDto;
import com.ServiceInterface.UserServiceInterface;
import com.dto.UserDto;
import com.entity.Users;
import com.exception.ResourceNotFoundException;
import com.repository.UserRepository;
import com.utility.Pagination;
@Service
public class UserServiceImpl implements UserServiceInterface
{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	

	
	//post user new create
	@Override
	public Users creatUser(UserDto userDto)
	{
	  Users user=new Users();
	  user.setEmail(userDto.getEmail());
	  user.setName(userDto.getName());
	  user.setPassword(passwordEncoder.encode(userDto.getPassword()));
	  return this.userRepository.save(user);
     }

	
	@Override
	public Users FindByEmail(String email)
	{
		Users user =this.userRepository.findByEmail(email);
		return  user;
		
	}
	
	@Override
	//get all users with pagination
	public Page<IUserListDto> getAllUsers(String search, String pageNumber, String pageSize) 
	{
		
		
		Pageable pagable=new Pagination().getPagination(pageNumber, pageSize);
		if((search=="")||(search==null)||(search.length()==0))
		{
			return userRepository.findByOrderById(pagable,IUserListDto.class);
		}
		else
		{
			return  userRepository.findByName(search,pagable,IUserListDto.class);
		}
		
	}
	
	@Override
	public UserDto getUserId(Integer id)
	{
		Users userEntity=userRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Not Found User Id"));
		
		UserDto userDto=new UserDto();
		userDto.setName(userEntity.getName());
		userDto.setEmail(userEntity.getEmail());
		return userDto;
		
	}


	
	// update by id
	@Override
	public UserDto updateUser(UserDto userDto, Integer id) {
		
		Users userEntity=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found User Id"));
		
		
		userEntity.setEmail(userDto.getEmail());
		userEntity.setName(userDto.getName());
		
		String password=passwordEncoder.encode(userDto.getPassword());
		userEntity.setPassword(password);
		
		userRepository.save(userEntity);
		return userDto;
	}

	
	
	 // delete by user id
	@Override
	public void deleteUser(Integer userId) 
	{
		this.userRepository.findById(userId).orElseThrow( () ->
		new ResourceNotFoundException("User Not Found With Id :"+userId));
		this.userRepository.deleteById(userId);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public UserDetails loadUserByUsername(String email) 
	{
		
		return null;
	}

	

	public void createUser(UserDto userdto) {
		
	}


	
	


	


	

	


	
	
}
