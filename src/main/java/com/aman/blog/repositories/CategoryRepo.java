package com.aman.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aman.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	
}
