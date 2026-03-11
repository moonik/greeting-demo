package com.example.demo.application.ports.in;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GreetingPort {

    void saveGreeting(GreetingDTO greeting);

    GreetingDTO getGreetingById(Integer id);

    List<GreetingDTO> getGreetingByName(String name);
}
