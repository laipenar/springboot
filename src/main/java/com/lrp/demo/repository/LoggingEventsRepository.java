package com.lrp.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.lrp.demo.event.LoggingEvent;
import com.lrp.demo.model.Logs;

public interface LoggingEventsRepository extends CrudRepository<Logs, Long> { 

	   
}
