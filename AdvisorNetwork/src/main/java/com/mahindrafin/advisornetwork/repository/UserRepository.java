package com.mahindrafin.advisornetwork.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahindrafin.advisornetwork.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
}