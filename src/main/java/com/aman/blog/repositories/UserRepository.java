package com.aman.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aman.blog.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional< User> findByEmail(String email);
	
}
