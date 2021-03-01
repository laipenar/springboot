package com.lrp.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrp.demo.model.User;
import com.lrp.demo.repository.UserRepository;
import com.lrp.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public User findUserByEmailAndPasswrd(String email, String passwrd) {
		return userRepository.findUserByEmailAndPasswrd(email, passwrd);
	}

}
