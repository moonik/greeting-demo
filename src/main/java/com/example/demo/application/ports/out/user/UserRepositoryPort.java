package com.example.demo.application.ports.out.user;

import com.example.demo.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {

    void save(User user);
    Optional<User> findByEmail(String email);
}
