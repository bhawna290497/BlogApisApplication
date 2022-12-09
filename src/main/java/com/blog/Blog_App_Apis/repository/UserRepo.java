package com.blog.Blog_App_Apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Blog_App_Apis.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
