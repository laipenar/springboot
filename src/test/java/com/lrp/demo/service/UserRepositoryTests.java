package com.lrp.demo.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.lrp.demo.model.User;
import com.lrp.demo.repository.UserRepository;
import com.lrp.demo.service.impl.UserServiceImpl;

@SpringBootTest
class UserRepositoryTests {

	@Mock
	private UserRepository userRepository;
	
	private UserService userService;
	
	
	@Test
	public void shouldReturnUser () {
		userService = new UserServiceImpl(userRepository);
		User user = new User();
		user.setEmail("myEmail@test.com");
		user.setName("John");
		user.setPasswrd("password");
		when(userRepository.findUserByEmail(user.getEmail())).thenReturn(user);

		assertTrue("John".equals(userService.findByEmail(user.getEmail()).getName()));
		
	}
	
}
