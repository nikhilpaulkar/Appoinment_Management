package com.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ServiceInterface.IRoleListDto;

import com.ServiceInterface.RoleServiceInterface;
import com.dto.RoleDto;

import com.entity.RoleEntity;

import com.exception.ResourceNotFoundException;
import com.repository.RoleRepository;
import com.utility.Pagination;

@Service
public class RoleServiceImpl implements RoleServiceInterface
{
  @Autowired
  private RoleRepository roleRepository;
	
    // add role
	@Override
	public void addrole(RoleDto roleDto)
	{
		RoleEntity roleEntity= new RoleEntity();
		roleEntity.setId(roleDto.getId());
		roleEntity.setRoleName(roleDto.getRoleName());
		roleRepository.save(roleEntity);
		
	}
    
	//get all roles with pagination
	@Override
	public Page<IRoleListDto> getAllrole(String search, String pageNumber, String pageSize) 
	{
		Pageable pagable=new Pagination().getPagination(pageNumber, pageSize);
		if((search=="")||(search==null)||(search.length()==0))
		{
			return roleRepository.findByOrderById(pagable,IRoleListDto.class);
		}
		else
		{
			return  roleRepository.findByRoleName(search,pagable,IRoleListDto.class);
		}
		
	
	}
	
    // get role by id
	@Override
	public RoleDto getRoleId(Integer id) 
	{
        RoleEntity roleEntity=roleRepository.findById(id).orElseThrow(()-> 
        new ResourceNotFoundException("Not Found role Id"));
		RoleDto roleDto=new RoleDto();
		roleDto.setId(roleEntity.getId());
		roleDto.setRoleName(roleEntity.getRoleName());
		return roleDto;
		
	}

	// update by RoleId 
	@Override
	public RoleDto updaterole(RoleDto roleDto, Integer id) 
	{
	   RoleEntity roleEntity=roleRepository.findById(id).orElseThrow(()-> 
	   new ResourceNotFoundException("Not Found role Id"));
		
		
		roleEntity.setRoleName(roleDto.getRoleName());
		roleRepository.save(roleEntity);
		return roleDto;
		
	}
    
	// delete by role id 
	@Override
	public void deleteRole(Integer roleId)
	{
		this.roleRepository.findById(roleId).orElseThrow( () ->
		new ResourceNotFoundException("role Not Found With Id :"+roleId));
		this.roleRepository.deleteById(roleId);
	}

}
