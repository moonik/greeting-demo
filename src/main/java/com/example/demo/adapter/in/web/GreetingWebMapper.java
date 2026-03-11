package com.example.demo.adapter.in.web;

import com.example.demo.application.ports.in.GreetingCommand;
import com.example.demo.domain.model.Greeting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GreetingWebMapper {
    GreetingCommand toCommand(GreetingDTO dto);
    GreetingDTO toDto(Greeting domain);
}
