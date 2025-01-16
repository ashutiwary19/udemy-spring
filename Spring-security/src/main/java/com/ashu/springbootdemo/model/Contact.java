package com.ashu.springbootdemo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Contact {

	@NotBlank(message = "Name cannot be blank")
	String name;

	@NotBlank(message = "Mobile cannot be blank")
	@Pattern(regexp = "(^$|[0-9]{10})")
	String mobileNum;

	@NotBlank(message = "Email cannot be blank")
	@Email
	String email;

	@NotBlank(message = "Subject cannot be blank")
	@Size(min = 5, message = "Subject should be more than 5 characters")
	String subject;

	@NotBlank(message = "Message cannot be blank")
	@Size(min = 10, message = "Message should be more than 5 characters")
	String message;
}
