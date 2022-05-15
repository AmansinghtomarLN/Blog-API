package com.aman.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotBlank
	@Size(min=4, message = "Username must be of 4 character")
	private String name;
	
	@Email(message = "Email adddress not valid")
	private String email;
	
	@NotEmpty
	@Size(min=3, max=10, message="password must be minimum of 3 chars and max of 10 chars")
	private String about;
	@NotEmpty
	private String password;
	
	
}
