package com.example.demo.application.service;

import com.example.demo.application.ports.in.user.UserLoginCommand;
import com.example.demo.application.ports.in.user.UserRegistrationCommand;
import com.example.demo.application.ports.in.user.UserPort;
import com.example.demo.application.ports.out.user.JwtTokenPort;
import com.example.demo.application.ports.out.user.PasswordEncoderPort;
import com.example.demo.application.ports.out.user.UserRepositoryPort;
import com.example.demo.domain.exception.UserNotFoundException;
import com.example.demo.domain.model.JwtToken;
import com.example.demo.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserPort {

    private final UserRepositoryPort userRepository;
    private final PasswordEncoderPort passwordEncoder;
    private final JwtTokenPort jwtTokenPort;

    @Override
    public void save(UserRegistrationCommand user) {
        var encodedPassword = passwordEncoder.encode(user.password());
        var model = new User(user.email(), encodedPassword);
        this.userRepository.save(model);
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }

    @Override
    public JwtToken login(UserLoginCommand userLoginCommand) {
        var user = this.findByEmail(userLoginCommand.email());

        if (user == null) {
            throw new UserNotFoundException(userLoginCommand.email());
        }

        if (!passwordEncoder.matches(user.password(), user.password())) {
            throw new IllegalArgumentException("Wrong password");
        }

        return new JwtToken(jwtTokenPort.generateToken(user.email()));
    }
}
