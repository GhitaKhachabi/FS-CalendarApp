package org.example.backend.dtos;

public class RegisterResponse {
    private String message;
    private String email;
    private String username;

    public RegisterResponse(String message, String email, String username) {
        this.message = message;
        this.email = email;
        this.username = username;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

