package com.lrp.demo.event;

import com.lrp.demo.dto.UserDto;

public interface LoggingEvent {

	public void logEvent(UserDto userDto);
}
