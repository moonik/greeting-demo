package com.example.demo.adapter.in;

import com.example.demo.application.ports.in.GreetingDTO;
import com.example.demo.application.ports.in.GreetingPort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hello")
@AllArgsConstructor
public class GreetingController {

    private final GreetingPort greetingPort;

    @PostMapping("")
    public String sayHello(@RequestBody GreetingDTO greetingDTO) {
        return greetingDTO.greeting() + " " + greetingDTO.name();
    }

    @PostMapping("/save")
    public void save(@RequestBody GreetingDTO greetingDTO) {
        this.greetingPort.saveGreeting(greetingDTO);
    }

    @GetMapping("/{id}")
    public GreetingDTO getGreetingById(@PathVariable Integer id) {
        return this.greetingPort.getGreetingById(id);
    }

    @GetMapping("")
    public List<GreetingDTO> getGreetingByName(@RequestParam String name) {
        return this.greetingPort.getGreetingByName(name);
    }
}
