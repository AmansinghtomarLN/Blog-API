package com.aman.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aman.blog.entities.Category;
import com.aman.blog.entities.Post;
import com.aman.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}
