package com.example.demo.adapter.out.persistence;

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
public class Greeting {

    @Id @GeneratedValue
    private Integer id;
    private String greeting;
    private String name;

    public Greeting(String greeting, String name) {
        this.greeting = greeting;
        this.name = name;
    }
}
