package com.blog.Blog_App_Apis.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min =4, message = "User Name must have atleast four characters")
	private String name;
	
	@Email(message = "Your email address is invalid")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be minimum of 3 character and max of 10")
	private String password;
	
	@NotEmpty
	private String about;
}
