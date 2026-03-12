package com.example.demo.application.ports.in.user;

import com.example.demo.domain.model.User;

public interface UserPort {

    void save(UserCommand user);
    User findByEmail(String email);
}
