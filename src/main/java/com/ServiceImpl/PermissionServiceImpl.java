package com.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ServiceInterface.IPermissionListDto;
import com.ServiceInterface.IUserListDto;
import com.ServiceInterface.PermissionServiceInterface;
import com.dto.PermissionDto;
import com.dto.RoleDto;
import com.entity.PermissionEntity;
import com.entity.RoleEntity;
import com.exception.ResourceNotFoundException;
import com.repository.PermissionRepository;
import com.utility.Pagination;

@Service
public class PermissionServiceImpl implements PermissionServiceInterface 
{
    @Autowired
    private PermissionRepository permissionRepository;
    
    
    // add permission
	@Override
	public void addPermission(PermissionDto permissionDto)
	{
		PermissionEntity permissionEntity= new PermissionEntity();
		permissionEntity.setId(permissionDto.getId());
		permissionEntity.setActionName(permissionDto.getActionName());
		permissionEntity.setBaseUrl(permissionDto.getBaseUrl());
		permissionEntity.setMethod(permissionDto.getMethod());
		permissionEntity.setPath(permissionDto.getPath());
		permissionRepository.save(permissionEntity);
		
	}

	
    // get all permission with pagination 
	@Override
	public Page<IPermissionListDto> getAllPermission(String search, String pageNumber, String pageSize) 
	{
		Pageable pagable=new Pagination().getPagination(pageNumber, pageSize);
		if((search=="")||(search==null)||(search.length()==0))
		{
			return permissionRepository.findByOrderById(pagable,IPermissionListDto.class);
		}
		else
		{
			return  permissionRepository.findByActionName(search,pagable,IPermissionListDto.class);
		}
		
	}

    // get permission by id 
	@Override
	public PermissionDto getPermissionId(Integer id)
	{

        PermissionEntity permissionEntity=permissionRepository.findById(id).orElseThrow(()-> 
        new ResourceNotFoundException("Not Found permission  Id"));
		PermissionDto permissionDto= new PermissionDto();
		
		permissionDto.setId(permissionEntity.getId());
		permissionDto.setActionName(permissionEntity.getActionName());
		permissionDto.setBaseUrl(permissionEntity.getBaseUrl());
		permissionDto.setMethod(permissionEntity.getMethod());
		permissionDto.setPath(permissionEntity.getPath());
		
		return permissionDto;
		
		
	}

    // update by permission id 
	@Override
	public PermissionDto updatepermission(PermissionDto permissionDto, Integer id) 
	{
		PermissionEntity permissionEntity=permissionRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Not Found permission Id"));
		
		permissionEntity.setActionName(permissionDto.getActionName());
		permissionEntity.setBaseUrl(permissionDto.getBaseUrl());
		permissionEntity.setMethod(permissionDto.getMethod());
		permissionEntity.setPath(permissionDto.getPath());
		permissionRepository.save(permissionEntity);
		return permissionDto;
			
		
	}

    // delete by permission id 
	@Override
	public void deletePermission(Integer permissionId) 
	{
		this.permissionRepository.findById(permissionId).orElseThrow( () ->
		new ResourceNotFoundException("permission Not Found With Id :"+permissionId));
		this.permissionRepository.deleteById(permissionId);
		
	}

}
