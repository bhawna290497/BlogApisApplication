package com.blog.Blog_App_Apis.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.Blog_App_Apis.exceptions.ResourceNotFoundException;
import com.blog.Blog_App_Apis.payloads.ApiResponse;
import com.blog.Blog_App_Apis.payloads.CategoryDto;
import com.blog.Blog_App_Apis.services.CategoryService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	//create
	
	/**
	 *This method is use for Create new category
	 * @author Bhawna Jain
	 * @param categoryDto this is the parameter to createCategory() method
	 * @since 02/12/2022 
	 * @return createCategory() is return the created category information 
	 */
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto)
	{
		CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
	}
	
	/**
	 *This method is use for update category which is already exist in database 
	 * @author Bhawna Jain
	 * @param categoryDto this is the first parameter to updateCategory() method
	 * @param catId this is the second parameter to updateCategory() method
	 * @since 02/12/2022 
	 * @exception ResourceNotFoundException when entering the id
	 * @see ResourceNotFoundException
	 * @return updateCategory() is return the updated category information 
	 */
	
	//update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId)
	{
		CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, catId);
		return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);
	}
	
	/**
	 *This method is use for delete category which is already exist in database 
	 * @author Bhawna Jain
	 * @param categoryDto this is the first parameter to deleteCategory() method
	 * @param catId this is the second parameter to deleteCategory() method
	 * @since 02/12/2022 
	 * @exception ResourceNotFoundException when entering the id
	 * @see ResourceNotFoundException
	 * @return deleteCategory() is return the deleted category information, which hard deleted 
	 */
	
	//delete
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId)
	{
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully", true), HttpStatus.OK);
	}
	
	//get
	/**
	 *This method is use for get category which is already exist in database 
	 * @author Bhawna Jain
	 * @param catId this is the parameter to getCategory() method
	 * @since 02/12/2022 
	 * @exception ResourceNotFoundException when entering the id
	 * @see ResourceNotFoundException
	 * @return getCategory() is return the category information about given id  
	 */
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId)
	{
		CategoryDto categoryDto = this.categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
	}
	
	
	/**
	 *This method is use for get all category which is already exist in database 
	 * @author Bhawna Jain
	 * @param agrs unused
	 * @since 02/12/2022 
	 * @return getAllCategory() is return the all category information 
	 */
	//get All
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory()
	{
		 List<CategoryDto> categories = this.categoryService.getAllCategories();
		return ResponseEntity.ok(categories);
	}
	
}
