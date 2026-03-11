package com.example.demo.adapter.out.persistence;

import com.example.demo.application.ports.out.GreetingRepositoryPort;
import com.example.demo.domain.model.Greeting;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class GreetingPersistenceAdapter implements GreetingRepositoryPort {

    private final GreetingJpaRepository repoAdapter;

    @Override
    public void save(Greeting domain) {
        var entity = new GreetingJpaEntity(domain.greeting(), domain.name());
        this.repoAdapter.save(entity);
    }

    @Override
    public Optional<Greeting> findById(Integer id) {
        return this.repoAdapter.findById(id)
                .map(greeting -> new Greeting(greeting.getGreeting(), greeting.getName()));
    }

    @Override
    public List<Greeting> findByName(String name) {
        return this.repoAdapter.findByName(name).stream()
                .map(g -> new Greeting(g.getGreeting(), g.getName()))
                .toList();
    }
}
