package com.lrp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.lrp.demo.service.UserService;


@RestController
public class UserController {
	
    @Autowired
    private UserService userService;
    
	@RequestMapping("/users")
	public String index() {
		return new Gson().toJson(userService.getAllUsers());	
	}
	
	
}
