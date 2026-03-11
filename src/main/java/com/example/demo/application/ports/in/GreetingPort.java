package com.example.demo.application.ports.in;

import com.example.demo.adapter.in.GreetingDTO;

import java.util.List;

public interface GreetingPort {

    void saveGreeting(GreetingCommand greeting);

    GreetingDTO getGreetingById(Integer id);

    List<GreetingDTO> getGreetingByName(String name);
}
