package com.blog.Blog_App_Apis.services;

import java.util.List;

import com.blog.Blog_App_Apis.payloads.CategoryDto;

public interface CategoryService {

	//create
	
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	void deleteCategory(Integer categoryId);
	
	//get
	CategoryDto getCategory(Integer categoryId);
	
	//getAll
	List<CategoryDto> getAllCategories();
	
	
}
