package com.aman.blog.services;

import java.util.List;

import com.aman.blog.entities.Post;
import com.aman.blog.payloads.PostDto;

public interface PostService {

	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	PostDto updatePost(PostDto postDto, Integer postId);
	void deletePost(Integer postId);
	List<PostDto> getAllPost();
	List<PostDto> getPostByCategory(Integer categoryId);
	List<PostDto> getPostByUser(Integer userId);
	List<PostDto> searchPost(String keyword);
	
	
}
