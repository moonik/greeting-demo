package com.example.demo.domain.exception;

public class GreetingNotFoundException extends RuntimeException {

    public GreetingNotFoundException(Integer id) {
        super("Greeting with ID " + id + " was not found.");
    }

    public GreetingNotFoundException(String name) {
        super("Greeting with Name " + name + " was not found.");
    }
}