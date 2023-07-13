package com.mahindrafin.advisornetwork.service;



import com.mahindrafin.advisornetwork.model.User;
import com.mahindrafin.advisornetwork.repository.UserRepository;
import com.mahindrafin.advisornetwork.security.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserRegistrationService(UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public String registerUser(User user) {
        // Validate required fields
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Name, email, and password are required");
        }

        userRepository.save(user);

        // Generate JWT authentication token
        String authToken = jwtTokenProvider.generateToken(user.getId().toString());

        return authToken;
    }

    public String loginUser(String email, String password) {
        // Implement login logic
        // Validate email and password combination

        // Generate JWT authentication token
        String authToken = jwtTokenProvider.generateToken(userId.toString());

        return authToken;
    }
}