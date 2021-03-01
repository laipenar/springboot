package com.lrp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.lrp.demo.service.impl.LoggingEventServiceImpl;


@RestController
public class LogController {
	
    @Autowired
    private LoggingEventServiceImpl logService;
    
	@RequestMapping("/logs")
	public String index() {
		return new Gson().toJson(logService.getAllLogs());	
	}
	
	
}
