package com.MovieBooking.App.service;

import com.MovieBooking.App.DTO.LoginRequestDTO;
import com.MovieBooking.App.DTO.LoginResponseDTO;
import com.MovieBooking.App.DTO.RegisterRequestDTO;
import com.MovieBooking.App.Repository.UserRepository;
import com.MovieBooking.App.entity.User;
import com.MovieBooking.App.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    //  REGISTER USER
    public User registerNormalUser(RegisterRequestDTO dto) {

        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new RuntimeException("User already registered");
        }

        Set<String> roles = new HashSet<>();
        roles.add("ROLE_USER");

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(roles);

        return userRepository.save(user);
    }

    //  REGISTER ADMIN
    public User registerAdminUser(RegisterRequestDTO dto) {

        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new RuntimeException("User already registered");
        }

        Set<String> roles = new HashSet<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(roles);

        return userRepository.save(user);
    }

    //  LOGIN (FIXED)
    public LoginResponseDTO login(LoginRequestDTO dto) {

        // 1. Authenticate first
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );

        // 2. Fetch fresh user from DB AFTER authentication
        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 3. Generate token
        String token = jwtService.generateToken(user);

        // 4. Return response
        return LoginResponseDTO.builder()
                .jwtToken(token)
                .username(user.getUsername())
                .roles(user.getRoles())
                .userId(user.getId())
                .build();
    }
}