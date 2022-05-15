package com.aman.blog.services;

import java.util.List;

import com.aman.blog.entities.Post;
import com.aman.blog.payloads.PostDto;

public interface PostService {

	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	PostDto updatePost(PostDto postDto, Integer postId);
	void deletePost(Integer postId);
	List<Post> getAllPost();
	List<Post> getPostByCategory(Integer categoryId);
	List<Post> getPostByUser(Integer userId);
	List<Post> searchPost(String keyword);
	
	
}
