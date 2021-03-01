package com.lrp.demo.event.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lrp.demo.dto.UserDto;
import com.lrp.demo.event.LoggingEvent;
import com.lrp.demo.service.LoggingEventService;

@Component
public class PasswordChangeEvent implements LoggingEvent {

	@Autowired
	private LoggingEventService loggingEventService;
	
	
	@Override
	public void logEvent(UserDto userDto) {
		loggingEventService.log(userDto);
	}

}
