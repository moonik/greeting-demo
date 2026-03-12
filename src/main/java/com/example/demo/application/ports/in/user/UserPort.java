package com.example.demo.application.ports.in.user;

import com.example.demo.domain.model.JwtToken;
import com.example.demo.domain.model.User;

public interface UserPort {

    void save(UserRegistrationCommand user);
    User findByEmail(String email);
    JwtToken login(UserLoginCommand userLoginCommand);
}
