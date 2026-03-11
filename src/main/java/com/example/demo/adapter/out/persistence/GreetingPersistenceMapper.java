package com.example.demo.adapter.out.persistence;

import com.example.demo.domain.model.Greeting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GreetingPersistenceMapper {
    GreetingJpaEntity toEntity(Greeting domain);
    Greeting toDomain(GreetingJpaEntity entity);
}