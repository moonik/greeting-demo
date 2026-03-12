package com.example.demo.adapter.in.web.user;

import com.example.demo.application.ports.in.user.UserLoginCommand;
import com.example.demo.application.ports.in.user.UserRegistrationCommand;
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
        var command = new UserRegistrationCommand(userDTO.email(), userDTO.password());
        this.userPort.save(command);
    }

    @PostMapping("/login")
    public JwtTokenDTO login(@RequestBody UserDTO userDTO) {
        var command = new UserLoginCommand(userDTO.email(), userDTO.password());
        var tokenValue = userPort.login(command);
        return new JwtTokenDTO(tokenValue.token());
    }
}
