package com.tyss.sample.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Component;

@Component
public class Utility {
	
	@PersistenceUnit
	EntityManagerFactory factory;
	
	@PersistenceContext
	EntityManager manager;
	
	public EntityManager dbConnector() {
		manager=factory.createEntityManager();
		return manager;
	}

}
