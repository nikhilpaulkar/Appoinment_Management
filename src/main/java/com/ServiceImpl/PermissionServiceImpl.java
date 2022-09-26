package com.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ServiceInterface.PermissionServiceInterface;
import com.dto.PermissionDto;
import com.entity.PermissionEntity;
import com.repository.PermissionRepository;

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

}
