package com.example.demo.adapter.in.web.user;

import com.example.demo.application.ports.in.user.UserCommand;
import com.example.demo.application.ports.in.user.UserPort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserPort userPort;

    @PostMapping("")
    public void save(@RequestBody UserDTO userDTO) {
        var command = new UserCommand(userDTO.email(), userDTO.password());
        this.userPort.save(command);
    }
}
