package com.ServiceInterface;




import org.springframework.data.domain.Page;


import com.dto.UserDto;
import com.entity.Users;

public interface UserServiceInterface
{

	Users creatUser(UserDto userDto);

	Users FindByEmail(String email);

	
	
    
	public void deleteUser(Integer userId);
	
	UserDto updateUser(UserDto userDto,Integer id);

	UserDto getUserId(Integer id);

	Page<IUserListDto> getAllUsers(String search, String pageNumber, String pageSize);

}
