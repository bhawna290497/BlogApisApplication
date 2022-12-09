package com.blog.Blog_App_Apis.services;

import java.util.List;

import com.blog.Blog_App_Apis.entities.Post;
import com.blog.Blog_App_Apis.payloads.PostDto;
import com.blog.Blog_App_Apis.payloads.PostResponse;

public interface PostService {

	//create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all post
	PostResponse getAllPost(Integer pagenumber, Integer pageSize, String sortBy, String sortDir);
	
	//get single post
	PostDto getPostById(Integer postId);
	
	//get all Posts by category
	List<PostDto> getPostsbyCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//search posts
	List<Post> searchPosts(String keyword);
	
}
