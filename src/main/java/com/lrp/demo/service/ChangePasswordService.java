package com.lrp.demo.service;

import com.lrp.demo.dto.UserDto;

public interface ChangePasswordService {
	public boolean changePassword (UserDto userDto, StringBuilder errorMsg);
}
