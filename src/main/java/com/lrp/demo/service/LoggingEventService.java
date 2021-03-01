package com.lrp.demo.service;

import java.util.List;

import com.lrp.demo.dto.UserDto;
import com.lrp.demo.model.Logs;

public interface LoggingEventService {
	public void log (UserDto userDto);
	public List<Logs> getAllLogs();
}
