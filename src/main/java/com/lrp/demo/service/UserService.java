package com.lrp.demo.service;

import java.util.List;

import com.lrp.demo.model.User;

public interface UserService {
	List<User> getAllUsers();
	
	User findByEmail(String email);
	
	void save (User user);

	User findUserByEmailAndPasswrd(String email, String passwrd);
}
