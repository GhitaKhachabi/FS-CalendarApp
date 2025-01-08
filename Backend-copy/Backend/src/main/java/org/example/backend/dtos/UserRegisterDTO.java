package org.example.backend.dtos;

import lombok.Data;

@Data
public class UserRegisterDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}

