package com.mateus.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.hroauth.entities.User;
import com.mateus.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {
	
	private static Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmal(email).getBody();
		if(user == null) {
			log.error("Email nao encontrado: "+email);
			throw new IllegalArgumentException("Email nao encontrado");
		}
		log.info("Email encontrado: "+email);
		return user;
	}
	
}
