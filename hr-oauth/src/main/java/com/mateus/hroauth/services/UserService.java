package com.mateus.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mateus.hroauth.entities.User;
import com.mateus.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService{
	
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmal(username).getBody();
		if(user == null) {
			log.error("Email nao encontrado: "+username);
			throw new UsernameNotFoundException("Email nao encontrado");
		}
		log.info("Email encontrado: "+username);
		return user;
	}
	
}
