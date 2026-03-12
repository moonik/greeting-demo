package com.example.demo.application.ports.out.user;

public interface JwtTokenPort {
    String generateToken(String email);
}
