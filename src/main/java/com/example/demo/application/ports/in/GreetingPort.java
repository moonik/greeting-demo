package com.example.demo.application.ports.in;

import com.example.demo.adapter.in.GreetingDTO;
import com.example.demo.domain.model.Greeting;

import java.util.List;

public interface GreetingPort {

    void saveGreeting(GreetingCommand greeting);

    Greeting getGreetingById(Integer id);

    List<Greeting> getGreetingByName(String name);
}
