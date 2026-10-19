package com.MovieBooking.App.DTO;



public class LoginRequestDTO {
    private String username;
    private String password;

    public LoginRequestDTO(String password, String username) {
        this.password = password;
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginRequestDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
