package com.lrp.demo.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.lrp.demo.dto.UserDto;
import com.lrp.demo.validation.Validation;

@SpringBootTest
public class ValidationTest {

	@Autowired
	private Validation validation;
	
	
	@Before(value = "")
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void shouldReturnEmailIsRequired() {
		
		UserDto userDto = new UserDto();
		userDto.setEmail(" ");
		userDto.setNewPassword("testpass");
		userDto.setConfirmPassword("testpass");
		StringBuilder errorMsg = new StringBuilder();
		
		validation.validate(userDto, errorMsg);
		assertTrue("Email is required.".equals( errorMsg.toString().trim()));
	}
	
	@Test
	public void shouldReturnEmailInvalid() {
		
		UserDto userDto = new UserDto();
		userDto.setEmail("testEmail");
		userDto.setNewPassword("testpass");
		userDto.setConfirmPassword("testpass");
		StringBuilder errorMsg = new StringBuilder();
		
		validation.validate(userDto, errorMsg);
		assertTrue("Email Invalid.".equals( errorMsg.toString().trim()));
	}
	
	@Test
	public void shouldReturnNewPasswordIsRequired() {
		
		UserDto userDto = new UserDto();
		userDto.setEmail("myEmail@gmail.com");
		userDto.setConfirmPassword("testpass");
		StringBuilder errorMsg = new StringBuilder();
		validation.validate(userDto, errorMsg);
		assertTrue("New Password is required.".equals( errorMsg.toString().trim()));
	}
	
	
	@Test
	public void shouldReturnNewPasswordAndConfirmPasswordDontMatch() {
		
		UserDto userDto = new UserDto();
		userDto.setEmail("myEmail@gmail.com");
		userDto.setNewPassword("newPassword");
		userDto.setConfirmPassword("confirmPassword");
		StringBuilder errorMsg = new StringBuilder();
		validation.validate(userDto, errorMsg);
		assertTrue("New Password and Confirm Password doesn't match.".equals( errorMsg.toString().trim()));
	}
}
