package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.User;
@Repository
public interface AuthRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

}
