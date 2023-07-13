package com.mahindrafin.advisornetwork.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindrafin.advisornetwork.model.Advisor;
import com.mahindrafin.advisornetwork.repository.AdvisorRepository;
import com.mahindrafin.advisornetwork.security.JwtTokenProvider;

@Service
public class AdminAdvisorService {
    private final AdvisorRepository advisorRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AdminAdvisorService(AdvisorRepository advisorRepository, JwtTokenProvider jwtTokenProvider) {
        this.advisorRepository = advisorRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public String addAdvisor(String name, String photoUrl) {
        // Validate required fields
        if (name == null || photoUrl == null) {
            throw new IllegalArgumentException("Advisor name and photo URL are required");
        }

        Advisor advisor = new Advisor(name, photoUrl);
        advisorRepository.save(advisor);

        // Generate JWT authentication token
        String authToken = jwtTokenProvider.generateToken(advisor.getId().toString());

        return authToken;
    }

    public List<Advisor> getAllAdvisors() {
        List<Advisor> advisors = advisorRepository.findAll();
        return advisors;
    }
}