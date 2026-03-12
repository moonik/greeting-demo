package com.example.demo.application.ports.in.greeting;

public record GreetingCommand(String greeting, String name) {
    public GreetingCommand {
        if (greeting == null || greeting.isBlank()) {
            throw new IllegalArgumentException("Greeting message cannot be empty");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        name = name.trim();
        greeting = greeting.trim();
    }
}
