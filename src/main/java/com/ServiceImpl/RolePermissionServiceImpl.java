package com.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ServiceInterface.RolePermissionServiceInterface;
import com.entity.PermissionEntity;
import com.entity.RoleEntity;
import com.entity.RolePermissionEntity;
import com.entity.RolePermissionId;

import com.exception.ResourceNotFoundException;
import com.payload.RolePermissionRequest;
import com.repository.PermissionRepository;
import com.repository.RolePermissionRepository;
import com.repository.RoleRepository;

@Service
public class RolePermissionServiceImpl implements RolePermissionServiceInterface
{
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RolePermissionRepository rolePermissionRepository;
    
	@Autowired
	private PermissionRepository permissionRepository;
	
	
	
	// add permission id and role id 
	@Override
	public void add(RolePermissionRequest rolePermissionRequest) 
	{
	  try
	  {
			
		ArrayList<RolePermissionEntity> permissions = new ArrayList<>();
		RoleEntity roleEntityId = this.roleRepository.findById(rolePermissionRequest.getRoleid()).orElseThrow(()-> new ResourceNotFoundException("Not Found roleid"));
		PermissionEntity permissionEntityId = this.permissionRepository.findById(rolePermissionRequest.getPermissionid()).orElseThrow(()-> 
		new ResourceNotFoundException("Not Found permissionid"));
		
		RolePermissionEntity rolePermissionEntity = new RolePermissionEntity();
		
		RolePermissionId rolePermissionId = new RolePermissionId(roleEntityId,permissionEntityId);
		rolePermissionEntity.setPk(rolePermissionId);
		permissions.add(rolePermissionEntity);
		rolePermissionRepository.saveAll(permissions);
	  }	catch(Exception e)
	  {
		  throw new ResourceNotFoundException("not found");
	  }
		
	}


    // get all permission id and role id 
	@Override
	public List<RolePermissionEntity> getAll() 
	{
		return this.rolePermissionRepository.findAll();
		
	}

    // update role id and permission id 
	@Override
	public void updateRolePermission(RolePermissionRequest rolePermissionRequest) 
	{
		RoleEntity roleEntity = this.roleRepository.findById(rolePermissionRequest.getRoleid()).get();
		PermissionEntity permissionEntity = this.permissionRepository.findById(rolePermissionRequest.getPermissionid()).get();
		
		RolePermissionEntity rolePermissionEntity = new RolePermissionEntity();
		RolePermissionId rolePermissionId = new RolePermissionId(roleEntity,permissionEntity);
		rolePermissionEntity.setPk(rolePermissionId);
		this.rolePermissionRepository.updateRolePermission(roleEntity.getId(), permissionEntity.getId());
		
		
	}

    // delete role id and permission id 
	@Override
	public void deleteRolePermission(RolePermissionRequest rolePermissionRequest)
	{
        RoleEntity roleEntity=this.roleRepository.findById(rolePermissionRequest.getRoleid()).get();
		
		PermissionEntity permissionEntity=this.permissionRepository.findById(rolePermissionRequest.getPermissionid()).get();
		
		RolePermissionEntity rolePermissionEntity=new RolePermissionEntity();
		
		RolePermissionId rolePermissionId=new RolePermissionId(roleEntity,permissionEntity);
		rolePermissionEntity.setPk(rolePermissionId);
		rolePermissionRepository.delete(rolePermissionEntity);
	}


	
	
	
	
}
