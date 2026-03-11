package com.example.demo.adapter.out.persistence;

import com.example.demo.application.ports.in.GreetingDTO;
import com.example.demo.application.ports.out.GreetingRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class GreetingPersistenceAdapter implements GreetingRepositoryPort {

    private final GreetingRepositoryAdapter repoAdapter;

    @Override
    public void save(GreetingDTO dto) {
        var greeting = new Greeting(dto.greeting(), dto.name());
        this.repoAdapter.save(greeting);
    }

    @Override
    public Optional<GreetingDTO> findById(Integer id) {
        var response = this.repoAdapter.findById(id);

        if (response.isEmpty()) {
            return Optional.empty();
        }

        var greeting = response.get();

        return Optional.of(new GreetingDTO(greeting.getGreeting(), greeting.getName()));
    }

    @Override
    public Optional<GreetingDTO> findByName(String name) {
        var response = this.repoAdapter.findByName(name);

        if (response.isEmpty()) {
            return Optional.empty();
        }

        var greeting = response.get();

        return Optional.of(new GreetingDTO(greeting.getGreeting(), greeting.getName()));
    }
}
