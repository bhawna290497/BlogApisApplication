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

import com.blog.Blog_App_Apis.exceptions.ResourceNotFoundException;
import com.blog.Blog_App_Apis.payloads.ApiResponse;
import com.blog.Blog_App_Apis.payloads.UserDto;
import com.blog.Blog_App_Apis.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * This method is use to create a new user
	 * @author Bhawna Jain
	 * @since 02/12/2022
	 * @param userDto this is the parameter for createUser() method 
	 * @return createUser() is return the information related to created user 
	 */
	//post-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	/**
	 * This method is use to update a user which is exist in database
	 * @author Bhawna Jain
	 * @since 02/12/2022
	 * @param userDto this is the first parameter for updateUser() method 
	 * @param userId this is the second parameter for updateUser() method
	 * @exception ResourceNotFoundException when entering id
	 * @see ResourceNotFoundException
	 * @return updateUser() is return the update user information  
	 */
	
	//PUT-create user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId)
	{
		UserDto updateuser = this.userService.updateuser(userDto, userId);
		return ResponseEntity.ok(updateuser);
	}
	

	/**
	 * This method is use to delete a user which is exist in database
	 * @author Bhawna Jain
	 * @since 02/12/2022
	 * @param userDto this is the first parameter for updateUser() method 
	 * @param userId this is the second parameter for updateUser() method
	 * @exception ResourceNotFoundException when entering id
	 * @see ResourceNotFoundException
	 * @return deleteUser() is return the delete user information which is hard deleted from database  
	 */
	//Delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid)
	{
		this.userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
	}
	

	/**
	 * This method is use to get a user which are exist in database
	 * @author Bhawna Jain
	 * @since 02/12/2022
	 * @param args unused
	 * @return getAllUser() is return the information related to all users database 
	 */
	//Get user get
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	

	/**
	 * This method is use to get a user which is exist in database
	 * @author Bhawna Jain
	 * @since 02/12/2022
	 * @param userId this is the parameter for updateUser() method
	 * @exception ResourceNotFoundException when entering id
	 * @see ResourceNotFoundException
	 * @return getSingleUser() is return the information related to given id 
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId)
	{
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
}
