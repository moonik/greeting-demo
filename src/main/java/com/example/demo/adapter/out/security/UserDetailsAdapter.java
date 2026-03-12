package com.example.demo.adapter.out.security;

import com.example.demo.application.ports.out.user.UserRepositoryPort;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDetailsAdapter implements UserDetailsService {
    private final UserRepositoryPort userRepository;

    @Override
    @NonNull
    public UserDetails loadUserByUsername(@NonNull String email) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(email)
                .map(user -> User.builder()
                        .username(user.email())
                        .password(user.password())
                        .roles("USER")
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
