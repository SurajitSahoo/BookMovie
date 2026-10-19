package com.MovieBooking.App.DTO;

//import lombok.Builder;
//import lombok.Data;

import java.util.Set;

//@Data
//@Builder
public class LoginResponseDTO {
    private String jwtToken;
    private String username;
    private Set<String> roles;
    private Long userId;

    public LoginResponseDTO() {
        super();
    }

    public LoginResponseDTO(String jwtToken, String username, Set<String> roles, Long userId) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.roles = roles;
        this.userId = userId;
    }

    public static Object builder() {
        return null;
    }

    @Override
    public String toString() {
        return "LoginResponseDTO{" +
                "jwtToken='" + jwtToken + '\'' +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                ", userId=" + userId +
                '}';
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
