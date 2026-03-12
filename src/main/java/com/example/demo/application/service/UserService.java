package com.example.demo.application.service;

import com.example.demo.application.ports.in.user.UserCommand;
import com.example.demo.application.ports.in.user.UserPort;
import com.example.demo.application.ports.out.user.PasswordEncoderPort;
import com.example.demo.application.ports.out.user.UserRepositoryPort;
import com.example.demo.domain.exception.UserNotFoundException;
import com.example.demo.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserPort {

    private final UserRepositoryPort userRepository;
    private final PasswordEncoderPort passwordEncoder;

    @Override
    public void save(UserCommand user) {
        var encodedPassword = passwordEncoder.encode(user.password());
        var model = new User(user.email(), encodedPassword);
        this.userRepository.save(model);
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }
}
