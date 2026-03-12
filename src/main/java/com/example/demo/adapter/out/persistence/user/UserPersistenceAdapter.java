package com.example.demo.adapter.out.persistence.user;

import com.example.demo.application.ports.out.user.UserRepositoryPort;
import com.example.demo.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserPersistenceAdapter implements UserRepositoryPort {

    private final UserJpaRepository repository;

    @Override
    public void save(User user) {
        var entity = new UserJpaEntity(user.email(), user.password());
        this.repository.save(entity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.repository.findByEmail(email).map(u -> new User(u.getEmail(), u.getPassword()));
    }
}
