package com.example.demo.adapter.out.persistence.greeting;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "greetings")
public class GreetingJpaEntity {

    @Id @GeneratedValue
    private Integer id;
    private String greeting;
    private String name;

    public GreetingJpaEntity(String greeting, String name) {
        this.greeting = greeting;
        this.name = name;
    }
}
