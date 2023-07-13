package com.mahindrafin.advisornetwork.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mahindrafin.advisornetwork.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}