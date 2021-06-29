package com.hello.spring.repository;

import com.hello.spring.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero,Integer> {
    Hero findByName(String name);

}
