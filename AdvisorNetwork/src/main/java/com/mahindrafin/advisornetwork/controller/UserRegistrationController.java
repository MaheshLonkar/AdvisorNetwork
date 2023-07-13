package com.mahindrafin.advisornetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mahindrafin.advisornetwork.dto.AuthResponseDTO;
import com.mahindrafin.advisornetwork.dto.UserDTO;
import com.mahindrafin.advisornetwork.security.JwtTokenProvider;
import com.mahindrafin.advisornetwork.service.UserRegistrationService;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {
    private final UserRegistrationService userRegistrationService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService, JwtTokenProvider jwtTokenProvider) {
        this.userRegistrationService = userRegistrationService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponseDTO registerUser(@RequestBody UserDTO userDTO) {
        userRegistrationService.registerUser(userDTO);

        // Generate JWT authentication token
        String authToken = jwtTokenProvider.generateToken(userDTO.getId().toString());

        // Create and return the authentication response
        return new AuthResponseDTO(authToken, userDTO.getId());
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponseDTO loginUser(@RequestBody UserDTO userDTO) {
        // Implement login logic
        // Validate email and password combination

        // Generate JWT authentication token
        String authToken = jwtTokenProvider.generateToken(userDTO.getId().toString());

        // Create and return the authentication response
        return new AuthResponseDTO(authToken, userDTO.getId());
    }
}