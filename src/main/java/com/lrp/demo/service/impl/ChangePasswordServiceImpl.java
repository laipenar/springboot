package com.lrp.demo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrp.demo.dto.UserDto;
import com.lrp.demo.event.impl.PasswordChangeEvent;
import com.lrp.demo.model.User;
import com.lrp.demo.repository.UserRepository;
import com.lrp.demo.service.ChangePasswordService;
import com.lrp.demo.service.UserService;

@Service
@Transactional
public class ChangePasswordServiceImpl implements ChangePasswordService{
	
	@Autowired
	public UserService userService;
	
	@Autowired
	private PasswordChangeEvent loggingEvent;
	
	public boolean changePassword (UserDto userDto, StringBuilder errorMsg)  {
		boolean isSuccess = true;
		User user = userService.findByEmail(userDto.getEmail());
		
		if (user != null) {
			user.setPasswrd(userDto.getNewPassword());
			userService.save(user);
			loggingEvent.logEvent(userDto);
		} else {
			errorMsg.append("User Not found " + userDto.getEmail());
			isSuccess = false;
		}
			
		return isSuccess;
	}
}
