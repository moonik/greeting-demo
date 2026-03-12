package com.example.demo.adapter.out.persistence.greeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GreetingJpaRepository extends JpaRepository<GreetingJpaEntity, Integer> {

    List<GreetingJpaEntity> findByName(String name);
}
