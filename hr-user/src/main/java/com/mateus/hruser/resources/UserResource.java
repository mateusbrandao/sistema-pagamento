package com.mateus.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.hruser.entities.User;
import com.mateus.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	UserRepository repository;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){

		User obj = repository.getReferenceById(id);
		return ResponseEntity.ok(obj);
		
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmal(@RequestParam String email){

		User obj = repository.findByEmail(email);
		return ResponseEntity.ok(obj);
		
	}
	
}
