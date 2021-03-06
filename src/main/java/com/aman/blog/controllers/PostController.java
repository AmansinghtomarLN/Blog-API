package com.aman.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aman.blog.entities.Post;
import com.aman.blog.payloads.PostDto;
import com.aman.blog.payloads.PostResponse;
import com.aman.blog.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;
	
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
		PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);
		
		return new ResponseEntity<PostDto>(createdPost,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		List<PostDto> posts = this.postService.getPostByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
		List<PostDto> posts = this.postService.getPostByCategory(categoryId);

		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	
	
	@GetMapping("/post")
	public ResponseEntity<List<PostDto>> getAllPosts(){
		List<PostDto> posts = this.postService.getAllPost();
	
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		PostDto post = this.postService.getPostById(postId);
	
		return new ResponseEntity<PostDto>(post, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<PostDto> deletePostById(@PathVariable Integer postId){
		this.postService.deletePost(postId);
	
		return new ResponseEntity(Map.of("message", "Deleted successfully"), HttpStatus.OK);
	}
	
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getPostByPagination(
			@RequestParam(value="pageNumber", defaultValue="0", required=false) Integer pageNumber, 
			@RequestParam(value="pageSize", defaultValue="5", required=false) Integer pageSize,
			@RequestParam(value="sortBy", defaultValue="postId", required=false) String sortBy){
		
		PostResponse posts = this.postService.getAllPostByPage(pageNumber, pageSize, sortBy);
	
		return new ResponseEntity<PostResponse>(posts, HttpStatus.OK);
		}
	
	
}






















