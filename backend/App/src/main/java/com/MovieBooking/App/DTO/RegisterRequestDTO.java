package com.MovieBooking.App.DTO;
import lombok.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {
    private String username;
    private String email;
    private String password;

//    public RegisterRequestDTO() {
//        // Default constructor (REQUIRED)
//    }
}
