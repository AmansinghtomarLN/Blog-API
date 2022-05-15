package com.aman.blog.services;

import java.util.List;

import com.aman.blog.payloads.CategoryDto;

public interface CategoryService {

	//create
	public CategoryDto create(CategoryDto categoryDto);

	//update
	public CategoryDto update(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	public void delete(Integer categoryId);

	//get Category
	public CategoryDto getCategory(Integer categoryId);
	
	// get All Category
	public List<CategoryDto> getAllCategory();
	
	
}
