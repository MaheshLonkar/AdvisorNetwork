package com.mahindrafin.advisornetwork.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mahindrafin.advisornetwork.model.Advisor;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
}