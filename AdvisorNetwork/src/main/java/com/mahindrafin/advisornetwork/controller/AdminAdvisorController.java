package com.mahindrafin.advisornetwork.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mahindrafin.advisornetwork.dto.AdvisorDTO;
import com.mahindrafin.advisornetwork.dto.AuthResponseDTO;
import com.mahindrafin.advisornetwork.security.JwtTokenProvider;
import com.mahindrafin.advisornetwork.service.AdminAdvisorService;

@RestController
@RequestMapping("/admin/advisor")
public class AdminAdvisorController {
    private final AdminAdvisorService adminAdvisorService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AdminAdvisorController(AdminAdvisorService adminAdvisorService, JwtTokenProvider jwtTokenProvider) {
        this.adminAdvisorService = adminAdvisorService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AuthResponseDTO addAdvisor(@RequestBody AdvisorDTO advisorDTO) {
        adminAdvisorService.addAdvisor(advisorDTO);

        // Generate JWT authentication token
        String authToken = jwtTokenProvider.generateToken(advisorDTO.getId().toString());

        // Create and return the authentication response
        return new AuthResponseDTO(authToken, advisorDTO.getId());
    }
}