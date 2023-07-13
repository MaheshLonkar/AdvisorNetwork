package com.mahindrafin.advisornetwork.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindrafin.advisornetwork.dto.AdvisorDTO;
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

    public String addAdvisor(AdvisorDTO advisorDTO) {
        // Validate required fields
        if (advisorDTO.getName() == null || advisorDTO.getPhotoUrl() == null) {
            throw new IllegalArgumentException("Advisor name and photo URL are required");
        }

        Advisor advisor = new Advisor();
        advisor.setName(advisorDTO.getName());
        advisor.setPhotoUrl(advisorDTO.getPhotoUrl());
        advisorRepository.save(advisor);

        // Generate JWT authentication token
        String authToken = jwtTokenProvider.generateToken(advisor.getId().toString());

        return authToken;
    }

    public List<Advisor> getAllAdvisors() {
        List<Advisor> advisors = advisorRepository.findAll();
        
        // Map the entities to DTOs
        List<AdvisorDTO> advisorDTOs = advisors.stream()
                .map(advisor -> new AdvisorDTO(advisor.getId(),advisor.getName(), advisor.getPhotoUrl()))
                .collect(Collectors.toList());
        return advisors;
    }
}