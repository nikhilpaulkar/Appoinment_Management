package com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ServiceInterface.IPermissionListDto;
import com.entity.PermissionEntity;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity , Integer>
{

	Page<IPermissionListDto> findByOrderById(Pageable pagable, Class<IPermissionListDto> class1);

	Page<IPermissionListDto> findByActionName(String search, Pageable pagable, Class<IPermissionListDto> class1);

}
