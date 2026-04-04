package com.MovieBooking.App.controller;

import com.MovieBooking.App.DTO.LoginRequestDTO;
import com.MovieBooking.App.DTO.LoginResponseDTO;
import com.MovieBooking.App.DTO.RegisterRequestDTO;
import com.MovieBooking.App.entity.User;
import com.MovieBooking.App.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/registernormaluser")
    public ResponseEntity<User> registerNormalUser(@RequestBody RegisterRequestDTO registerRequestDTO)
    {
        return ResponseEntity.ok(authenticationService.registerNormalUser(registerRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO)
    {
        return ResponseEntity.ok(authenticationService.login(loginRequestDTO));
    }
}
