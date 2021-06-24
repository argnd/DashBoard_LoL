package com.hello.spring;

import com.hello.spring.populatedb.populatedb;
import com.hello.spring.repository.HeroRepository;
import com.hello.spring.repository.TeamRepository;
import com.hello.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("all")
public class HelloSpringApplication implements CommandLineRunner {
     @Autowired
     HeroRepository heroRepository;
     @Autowired
     TeamRepository teamRepository;
     @Autowired
     UserRepository userRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloSpringApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        populatedb.populate(userRepository,teamRepository,heroRepository);
    }

}
