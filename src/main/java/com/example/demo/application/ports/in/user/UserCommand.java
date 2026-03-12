package com.example.demo.application.ports.in.user;

public record UserCommand(String email, String password) {
    public UserCommand {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
    }
}
