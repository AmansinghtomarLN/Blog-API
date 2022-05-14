package com.aman.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aman.blog.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
