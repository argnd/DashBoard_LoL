package com.hello.spring.repository;

import com.hello.spring.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero,Integer> {
}
