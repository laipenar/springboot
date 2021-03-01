package com.lrp.demo.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {
	
	private String email;
	
	private String currentPassword; 
	
	private String newPassword;
	
	private String confirmPassword;
	
	
}
