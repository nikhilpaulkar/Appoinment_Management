package com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ServiceInterface.IRoleListDto;

import com.entity.RoleEntity;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer>
{

	Page<IRoleListDto> findByOrderById(Pageable pagable, Class<IRoleListDto> class1);

	Page<IRoleListDto> findByRoleName(String search, Pageable pagable, Class<IRoleListDto> class1);

	 RoleEntity findByRoleName( String roleName);

	
}
                                      