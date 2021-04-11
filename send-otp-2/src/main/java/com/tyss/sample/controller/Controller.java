package com.tyss.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.sample.dto.ResponseBean;
import com.tyss.sample.dto.Users;
import com.tyss.sample.service.ServiceInf;

@RestController
@RequestMapping("/getotp/v1")
public class Controller {
	
	@Autowired
	ServiceInf service;
	@GetMapping("/register")
	public ResponseBean register(Users user) {
		StringBuffer response=service.register(user);
		return new ResponseBean(response);
		
	}
	

}
