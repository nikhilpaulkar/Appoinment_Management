package com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

	
	Page<?> findByName(String search, Pageable pagable, Class<User> class1);

}
