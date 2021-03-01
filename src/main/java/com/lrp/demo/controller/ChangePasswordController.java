package com.lrp.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lrp.demo.dto.UserDto;
import com.lrp.demo.service.ChangePasswordService;
import com.lrp.demo.validation.Validation;


@Controller
public class ChangePasswordController {

	
    @Autowired
    private ChangePasswordService changePasswordService;
    
    @Autowired
    private Validation formValidation;
    
	@GetMapping("/change_password")
	public String showChangePasswordPage () {
		return "changepassword";
	}
	
	@PostMapping("/save_password")
	public String saveNewPassword (HttpServletRequest request, Model model){
		
		UserDto userDto = new UserDto();
		userDto.setEmail(request.getParameter("email"));
		userDto.setCurrentPassword(request.getParameter("current_password"));
		userDto.setNewPassword(request.getParameter("new_password"));
		userDto.setConfirmPassword(request.getParameter("confirm_password"));

		StringBuilder errors = new StringBuilder();
		
		formValidation.validate(userDto, errors);
		
		if(errors.toString().trim().isEmpty()) { //all form inputs are valid
			changePasswordService.changePassword(userDto, errors);
		}

		if(!errors.toString().trim().isEmpty()) {
			model.addAttribute("errorMsg", errors.toString());
			return "changepassword";
		} else {
			model.addAttribute("successMsg", "Password was successfully changed");
			return "success";
		}
			
		
	}
	

	
}
