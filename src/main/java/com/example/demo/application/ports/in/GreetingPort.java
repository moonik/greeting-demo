package com.example.demo.application.ports.in;

public interface GreetingPort {

    void saveGreeting(GreetingDTO greeting);

    GreetingDTO getGreetingById(Integer id);

    GreetingDTO getGreetingByName(String name);
}
