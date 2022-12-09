package com.blog.Blog_App_Apis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Blog_App_Apis.entities.Category;
import com.blog.Blog_App_Apis.entities.Post;
import com.blog.Blog_App_Apis.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
}
