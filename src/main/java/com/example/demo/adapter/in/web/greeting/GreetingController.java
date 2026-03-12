package com.example.demo.adapter.in.web.greeting;

import com.example.demo.application.ports.in.greeting.GreetingCommand;
import com.example.demo.application.ports.in.greeting.GreetingPort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hello")
@AllArgsConstructor
public class GreetingController {

    private final GreetingPort greetingPort;

    @PostMapping("")
    public void save(@RequestBody GreetingDTO greetingDTO) {
        var command = new GreetingCommand(greetingDTO.greeting(), greetingDTO.name());
        this.greetingPort.saveGreeting(command);
    }

    @GetMapping("/{id}")
    public GreetingDTO getGreetingById(@PathVariable Integer id) {
        var greeting = this.greetingPort.getGreetingById(id);
        return new GreetingDTO(greeting.greeting(), greeting.name());
    }

    @GetMapping("")
    public List<GreetingDTO> getGreetingByName(@RequestParam String name) {
        return this.greetingPort.getGreetingByName(name).stream().map(g -> new GreetingDTO(g.greeting(), g.name())).toList();
    }
}
