package com.blog.Blog_App_Apis.payloads;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private Integer postId;
	@NotBlank
	@Size(min = 5, message = "Minimum size of title is 5")
	private String title;
	
	@NotBlank
	@Size(min = 10, message = "Minimum size of content is 10")
	private String content;
	private String imageName;
	private Date addedDate;
	
	private CategoryDto category;
	private UserDto user;
}
