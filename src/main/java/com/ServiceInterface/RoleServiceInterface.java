package com.ServiceInterface;

import org.springframework.data.domain.Page;

import com.dto.RoleDto;


public interface RoleServiceInterface 
{
	void addrole(RoleDto roleDto);
	
	Page<IRoleListDto> getAllrole(String search, String pageNumber, String pageSize);

	RoleDto getRoleId(Integer id);
	RoleDto updaterole(RoleDto roleDto, Integer id);

    void deleteRole(Integer roleId);
}
