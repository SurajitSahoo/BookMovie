package com.MovieBooking.App.jwt;

import com.MovieBooking.App.Repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
            //Auto generate through intelij idea
    final String authHeader = request.getHeader("Authorization");
    final String jwtToken;
    final String username;
    }
}
