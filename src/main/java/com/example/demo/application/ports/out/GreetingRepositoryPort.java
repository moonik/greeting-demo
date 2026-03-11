package com.example.demo.application.ports.out;

import com.example.demo.application.ports.in.GreetingDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface GreetingRepositoryPort {

    void save(GreetingDTO greeting);
    Optional<GreetingDTO> findById(Integer id);
    List<GreetingDTO> findByName(String name);
}
