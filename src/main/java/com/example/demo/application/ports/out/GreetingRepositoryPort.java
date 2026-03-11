package com.example.demo.application.ports.out;

import com.example.demo.domain.model.Greeting;

import java.util.List;
import java.util.Optional;

public interface GreetingRepositoryPort {

    void save(Greeting greeting);
    Optional<Greeting> findById(Integer id);
    List<Greeting> findByName(String name);
}
