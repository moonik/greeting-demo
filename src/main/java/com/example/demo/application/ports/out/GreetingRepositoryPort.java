package com.example.demo.application.ports.out;

import com.example.demo.adapter.in.GreetingDTO;
import com.example.demo.domain.model.Greeting;

import java.util.List;
import java.util.Optional;

public interface GreetingRepositoryPort {

    void save(Greeting greeting);
    Optional<GreetingDTO> findById(Integer id);
    List<GreetingDTO> findByName(String name);
}
