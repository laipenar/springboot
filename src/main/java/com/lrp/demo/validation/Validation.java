package com.lrp.demo.validation;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.EmailValidator;
import org.springframework.stereotype.Component;

import com.lrp.demo.dto.UserDto;

@Component
public class Validation {
	
	
	public void validate (UserDto userDto, StringBuilder error) {
		
		if(StringUtils.isBlank(userDto.getEmail()) ) {
			error.append("Email is required. \r\n");
		} 
		if (StringUtils.isBlank(userDto.getNewPassword())) {
			error.append("New Password is required. \r\n");
		} 
		if (!StringUtils.isBlank(userDto.getNewPassword()) && !userDto.getNewPassword().equals(userDto.getConfirmPassword())) {
			error.append("New Password and Confirm Password doesn't match. \r\n");
		} 
		if (!StringUtils.isBlank(userDto.getEmail()) && !EmailValidator.getInstance().isValid(userDto.getEmail())) {
			error.append("Email Invalid. \r\n"); 
		} 
		

	}
	
	
}
