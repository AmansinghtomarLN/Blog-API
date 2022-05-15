package com.aman.blog.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aman.blog.payloads.CategoryDto;
import com.aman.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto CategoryDto ) {

		CategoryDto createdCategoryDto = this.categoryService.create(CategoryDto);
		
		return new ResponseEntity<>(createdCategoryDto, HttpStatus.CREATED);
	}

	// PUT - update Category
	@PutMapping("/{CategoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto CategoryDto, @PathVariable("CategoryId") Integer CategoryId) {
		CategoryDto updatedCategory = this.categoryService.update(CategoryDto, CategoryId);
		return ResponseEntity.ok(updatedCategory);
	}

	// DELETE - delete Category
	@DeleteMapping("/{CategoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable("CategoryId") Integer CategoryId) {
		
	this.categoryService.delete(CategoryId);
	return new ResponseEntity(Map.of("message", "Deleted successfully"), HttpStatus.OK);
	}
	
	// GET - get Category
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		return ResponseEntity.ok(this.categoryService.getAllCategory());
	}
	
	@GetMapping("/{CategoryId}")
	public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer CategoryId){
		return ResponseEntity.ok(this.categoryService.getCategory(CategoryId));
	}
	
}
