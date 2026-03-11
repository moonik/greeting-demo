package com.example.demo.application.ports.out;

import com.example.demo.application.ports.in.GreetingDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface GreetingRepositoryPort {

    void save(GreetingDTO greeting);
    Optional<GreetingDTO> findById(Integer id);
    Optional<GreetingDTO> findByName(String name);
}
