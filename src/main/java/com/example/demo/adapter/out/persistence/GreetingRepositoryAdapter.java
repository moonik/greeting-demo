package com.example.demo.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GreetingRepositoryAdapter extends JpaRepository<Greeting, Integer> {

    Optional<Greeting> findByName(String name);
}
