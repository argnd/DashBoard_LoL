package com.hello.spring;

import com.hello.spring.repository.HeroRepository;
import com.hello.spring.repository.TeamRepository;
import com.hello.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("all")
public class HelloSpringApplication {
     @Autowired
     HeroRepository heroRepository;
     @Autowired
     TeamRepository teamRepository;
     @Autowired
     UserRepository userRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloSpringApplication.class, args);
    }

}
