package com.blog.Blog_App_Apis.services;

import java.util.List;

import com.blog.Blog_App_Apis.payloads.UserDto;

public interface UserService {


	 UserDto createUser(UserDto user);
	 UserDto updateuser(UserDto user, Integer userId);
	 UserDto getUserById(Integer userId);
	 List<UserDto> getAllUsers();
	 void deleteUser(Integer userId);
}
