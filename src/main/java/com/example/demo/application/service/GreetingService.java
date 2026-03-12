package com.example.demo.application.service;

import com.example.demo.application.ports.in.greeting.GreetingCommand;
import com.example.demo.application.ports.in.greeting.GreetingPort;
import com.example.demo.application.ports.out.greeting.GreetingRepositoryPort;
import com.example.demo.domain.exception.GreetingNotFoundException;
import com.example.demo.domain.model.Greeting;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GreetingService implements GreetingPort {

    private final GreetingRepositoryPort greetingRepository;

    @Override
    public void saveGreeting(GreetingCommand command) {
        var model = new Greeting(command.greeting(), command.name());
        this.greetingRepository.save(model);
    }

    @Override
    public Greeting getGreetingById(Integer id) {
        return this.greetingRepository.findById(id).orElseThrow(() -> new GreetingNotFoundException(id));
    }

    @Override
    public List<Greeting> getGreetingByName(String name) {
        return this.greetingRepository.findByName(name);
    }
}
