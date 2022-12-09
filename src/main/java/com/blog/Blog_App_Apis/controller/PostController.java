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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Blog_App_Apis.entities.Post;
import com.blog.Blog_App_Apis.exceptions.ResourceNotFoundException;
import com.blog.Blog_App_Apis.payloads.ApiResponse;
import com.blog.Blog_App_Apis.payloads.PostDto;
import com.blog.Blog_App_Apis.payloads.PostResponse;
import com.blog.Blog_App_Apis.services.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class PostController
{
	@Autowired
	private PostService postService;
	

	/**
	 *This method is use for create new new
	 * @author Bhawna Jain
	 * @param postDto this is the parameter to createPost() method
	 * @since 02/12/2022 
	 * @return createPost() is return the created post information 
	 */
	//create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> cretePost(@Valid @RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId)
	{
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);

		return new ResponseEntity<PostDto>(createPost, HttpStatus.OK);
	}
	/**
	 * This method is use to get a Post with the help of user id which is exist in database
	 * @author Bhawna Jain
	 * @since 02/12/2022
	 * @param userId this is the parameter for getPostByUser() method
	 * @exception ResourceNotFoundException when entering id
	 * @see ResourceNotFoundException
	 * @return getPostByUser() is return the information of Post related to given id 
	 */
	
	
	//get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		List<PostDto> posts = this.postService.getPostsByUser(userId);

		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

	}
	/**
	 * This method is use to get a Post with the help of category id which is exist in database
	 * @author Bhawna Jain
	 * @since 02/12/2022
	 * @param categoryId this is the parameter for getPostByCategory() method
	 * @exception ResourceNotFoundException when entering id
	 * @see ResourceNotFoundException
	 * @return getPostByCategory() is return the information of Post related to given id 
	 */
	// get by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
		List<PostDto> posts = this.postService.getPostsbyCategory(categoryId);

		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

	}

	/**
	 * This method is use to get all Posts which are exist in database
	 * @author Bhawna Jain
	 * @since 02/12/2022
	 * @param args unused
	 * @return getAllPost() is return the information related to all posts in database 
	 */

	//get all post

	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(@RequestParam(value = "pagenumber", defaultValue = "0", required = false) Integer pagenumber,
												   @RequestParam(value = "pageSize", defaultValue = "6", required = false) Integer pageSize,
												   @RequestParam (value = "sortBy", defaultValue = "postId", required = false) String sortBy,
												   @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir)
	{
		PostResponse allPost = this.postService.getAllPost(pagenumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<PostResponse>(allPost, HttpStatus.OK);
	}
	
	/**
	 * This method is use to get a Post which is exist in database
	 * @author Bhawna Jain
	 * @since 02/12/2022
	 * @param postId this is the parameter for getPostById() method
	 * @exception ResourceNotFoundException when entering id
	 * @see ResourceNotFoundException
	 * @return getPostById() is return the information of Post related to given id 
	 */

	//get post by id
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId)
	{
		PostDto postDto=this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}
	
	/**
	 * This method is use to delete a post which is exist in database
	 * @author Bhawna Jain
	 * @since 02/12/2022
	 * @param postDto this is the parameter for deletePost() method 
	 * @exception ResourceNotFoundException when entering id
	 * @see ResourceNotFoundException
	 * @return deleteUser() is return the deleted post information, which is hard deleted from database  
	 */
	
	//delete post

	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId)
	{
		this.postService.deletePost(postId);
		return new ApiResponse("Post is successfully deleted!", true);
	}

	/**
	 * This method is use to update a post which is exist in database
	 * @author Bhawna Jain
	 * @since 02/12/2022
	 * @param PostDto this is the first parameter for updatePost() method 
	 * @param postId this is the second parameter for updatePost() method
	 * @exception ResourceNotFoundException when entering id
	 * @see ResourceNotFoundException
	 * @return updatePost() is return the updated Post information  
	 */
	
	//update post
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Integer postId)
	{
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
	}
}