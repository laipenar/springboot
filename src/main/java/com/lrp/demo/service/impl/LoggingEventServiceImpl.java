package com.lrp.demo.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrp.demo.dto.UserDto;
import com.lrp.demo.model.Logs;
import com.lrp.demo.repository.LoggingEventsRepository;
import com.lrp.demo.service.LoggingEventService;

@Service
@Transactional
public class LoggingEventServiceImpl implements LoggingEventService{
	
	@Autowired
	public LoggingEventsRepository loggingEventsRepository;

	@Override
	public void log(UserDto userDto) {
		Logs logs = new Logs();
		logs.setTimestamp(new Date());
		logs.setLog("Changed password for user " + userDto.getEmail());
		loggingEventsRepository.save(logs);
	}
	
	public List<Logs> getAllLogs() {
		return (List<Logs>) loggingEventsRepository.findAll();
	}
	
}
