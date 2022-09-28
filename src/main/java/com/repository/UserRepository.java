package com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ServiceInterface.IUserListDto;

import com.entity.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer>
{

	Users findByEmail(String email);





	

	Page<IUserListDto> findByOrderById(Pageable pagable, Class<IUserListDto> class1);

    Page<IUserListDto> findByName(String search, Pageable pagable, Class<IUserListDto> class1);







	Users findByEmailContainingIgnoreCase(String email);




	



	



   

}
