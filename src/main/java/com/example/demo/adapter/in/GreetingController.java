package com.example.demo.adapter.in;

import com.example.demo.application.ports.in.GreetingDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
@AllArgsConstructor
public class GreetingController {

    @PostMapping("")
    public String sayHello(@RequestBody GreetingDTO greetingDTO) {
        return greetingDTO.greeting() + " " + greetingDTO.name();
    }

    @GetMapping("")
    public String sayHello() {
        return "Hello World";
    }
}
