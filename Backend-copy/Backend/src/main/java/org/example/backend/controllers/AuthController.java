package org.example.backend.controllers;

import org.example.backend.dtos.AuthRequest;
import org.example.backend.dtos.RegisterResponse;
import org.example.backend.entities.User;
import org.example.backend.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Register a new user.
     *
     * @param user The user object sent from the client.
     * @return A success message or an error if the user already exists.
     */
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody User user) {
        try {
            User registeredUser = authService.register(user);
            RegisterResponse response = new RegisterResponse(
                    "User registered successfully",
                    registeredUser.getEmail(),
                    registeredUser.getUsername()
            );
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new RegisterResponse(e.getMessage(), null, null));
        }
    }

    /**
     * Authenticate a user.
     *
     * @param authRequest Contains email and password.
     * @return The authenticated user or an error if login fails.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthRequest authRequest) {
        try {
            User user = authService.login(authRequest.getEmail(), authRequest.getPassword());
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
