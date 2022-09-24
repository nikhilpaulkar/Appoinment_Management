package com.ServiceInterface;




import org.springframework.data.domain.Page;


import com.dto.UserDto;
import com.entity.User;

public interface UserServiceInterface
{

	User creatUser(UserDto userDto);

	User FindByEmail(String email);

	
	Page<?> getUsers(String search, String pageNumber, String pageSize);
    
	public void deleteUser(Integer userId);
	
	UserDto updateUser(UserDto userDto,Integer id);

	UserDto getUserId(Integer id);

}
