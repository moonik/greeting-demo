package com.example.demo.adapter.in.web.greeting;

import com.example.demo.application.ports.in.greeting.GreetingCommand;
import com.example.demo.domain.model.Greeting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GreetingWebMapper {
    GreetingCommand toCommand(GreetingDTO dto);
    GreetingDTO toDto(Greeting domain);
}
