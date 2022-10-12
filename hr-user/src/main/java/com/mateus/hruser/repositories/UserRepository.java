package com.mateus.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
}
