package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.User;

public interface AuthRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

}
