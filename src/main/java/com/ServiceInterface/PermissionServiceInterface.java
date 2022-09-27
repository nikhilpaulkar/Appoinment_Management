package com.ServiceInterface;

import org.springframework.data.domain.Page;

import com.dto.PermissionDto;




public interface PermissionServiceInterface 
{
    void addPermission(PermissionDto permissionDto);
    Page<IPermissionListDto> getAllPermission(String search, String pageNumber, String pageSize);
    PermissionDto getPermissionId(Integer id);
    PermissionDto updatepermission(PermissionDto permissionDto, Integer id);
    void deletePermission(Integer roleId);
}
