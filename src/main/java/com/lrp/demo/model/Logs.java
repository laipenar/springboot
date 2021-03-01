package com.lrp.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Logs {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String log;
	
	@Column
	private Date timestamp;
}
