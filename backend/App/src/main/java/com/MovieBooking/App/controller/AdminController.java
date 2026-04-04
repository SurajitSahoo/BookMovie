package com.MovieBooking.App.controller;

import com.MovieBooking.App.DTO.RegisterRequestDTO;
import com.MovieBooking.App.entity.User;
import com.MovieBooking.App.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")  //THERE WILL BE NO PUBLIC API TO ADD ADMIN, INSERT BY SQL QUERY
public class AdminController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/registeradminuser")
    public ResponseEntity<User> registerAdminUser(@RequestBody RegisterRequestDTO registerRequestDTO)
    {
        return ResponseEntity.ok(authenticationService.registerAdminUser(registerRequestDTO));
    }
}
