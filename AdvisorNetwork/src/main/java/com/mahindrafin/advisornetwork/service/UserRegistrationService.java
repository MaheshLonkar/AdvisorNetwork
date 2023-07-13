package com.mahindrafin.advisornetwork.service;



import com.mahindrafin.advisornetwork.dto.UserDTO;
import com.mahindrafin.advisornetwork.model.User;
import com.mahindrafin.advisornetwork.repository.UserRepository;
import com.mahindrafin.advisornetwork.security.JwtTokenProvider;

import java.util.Optional;

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

    public String registerUser(UserDTO userDTO) {
        // Validate required fields
        if (userDTO.getName() == null || userDTO.getEmail() == null || userDTO.getPassword() == null) {
            throw new IllegalArgumentException("Name, email, and password are required");
        }

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);

        // Generate JWT authentication token
        String authToken = jwtTokenProvider.generateToken(user.getId().toString());

        return authToken;
    }

    public String loginUser(String email, String password) {
    	// Find the user by email
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Validate password (you may use encryption/hashing for passwords)
            if (user.getPassword().equals(password)) {
                // Generate a JWT token for the logged-in user
        String authToken = jwtTokenProvider.generateToken(user.getId().toString());


        return authToken; }
}
        return null; }}