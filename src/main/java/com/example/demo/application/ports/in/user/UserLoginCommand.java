package com.example.demo.application.ports.in.user;

public record UserLoginCommand(String email, String password) {
    public UserLoginCommand {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
    }
}
