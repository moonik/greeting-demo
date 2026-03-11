package com.example.demo.application.service;

import com.example.demo.application.ports.in.GreetingDTO;
import com.example.demo.application.ports.in.GreetingPort;
import com.example.demo.application.ports.out.GreetingRepositoryPort;
import com.example.demo.common.utils.GreetingNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class GreetingService implements GreetingPort {

    private final GreetingRepositoryPort greetingRepository;

    @Override
    public void saveGreeting(GreetingDTO dto) {
        this.greetingRepository.save(dto);
    }

    @Override
    public GreetingDTO getGreetingById(Integer id) {
        return this.greetingRepository.findById(id).orElseThrow(() -> new GreetingNotFoundException(id));
    }

    @Override
    public List<GreetingDTO> getGreetingByName(String name) {
        return this.greetingRepository.findByName(name);
    }
}
