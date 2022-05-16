package com.aman.blog.services;

import java.util.List;

import com.aman.blog.entities.Post;
import com.aman.blog.payloads.PostDto;
import com.aman.blog.payloads.PostResponse;

public interface PostService {

	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	PostDto updatePost(PostDto postDto, Integer postId);
	void deletePost(Integer postId);
	List<PostDto> getAllPost();
	PostResponse getAllPostByPage(Integer pageNumber, Integer pageSize, String sortBy);
	List<PostDto> getPostByCategory(Integer categoryId);
	List<PostDto> getPostByUser(Integer userId);
	List<PostDto> searchPost(String keyword);
	PostDto getPostById(Integer postId);
	
	
}
