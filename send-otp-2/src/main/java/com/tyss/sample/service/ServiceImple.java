package com.tyss.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.sample.dao.DaoInf;
import com.tyss.sample.dto.Users;

@Service
public class ServiceImple implements ServiceInf {

	@Autowired
	DaoInf dao;
	
	@Override
	public StringBuffer register(Users user) {
		return dao.register(user);
	}

}
