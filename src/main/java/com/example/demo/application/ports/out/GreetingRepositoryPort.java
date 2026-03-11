package com.example.demo.application.ports.out;

import com.example.demo.adapter.in.GreetingDTO;
import com.example.demo.application.ports.in.GreetingCommand;

import java.util.List;
import java.util.Optional;

public interface GreetingRepositoryPort {

    void save(GreetingCommand greeting);
    Optional<GreetingDTO> findById(Integer id);
    List<GreetingDTO> findByName(String name);
}
