package com.example.demo.application.ports.in;

import org.springframework.stereotype.Component;

@Component
public interface GreetingPort {

    void saveGreeting(GreetingDTO greeting);

    GreetingDTO getGreetingById(Integer id);

    GreetingDTO getGreetingByName(String name);
}
