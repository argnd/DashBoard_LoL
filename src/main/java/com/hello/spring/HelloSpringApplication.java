package com.hello.spring;

import com.hello.spring.model.Hero;
import com.hello.spring.model.Team;
import com.hello.spring.model.User;
import com.hello.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HelloSpringApplication implements CommandLineRunner {

    @Autowired
    private  UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(HelloSpringApplication.class, args);
        //
    }


    @Override
    public void run(String... args) throws Exception {
        User tmp = new User();
        User tmp2 = new User();
        Team tmpt = new Team();
        Team tmpt2 = new Team();
        Hero tmph = new Hero();
        List<Hero> tmpset = new ArrayList<>();
        List<Hero> tmpset2 = new ArrayList<>();
        tmpset.add(tmph);
        tmpset.add(tmph);
        tmpset.add(tmph);
        tmpset.add(tmph);
        tmpset2.add(tmph);
        tmpset2.add(tmph);
        tmpset2.add(tmph);
        tmpset2.add(tmph);
        tmp.setUsername("Hello");
        tmpt.setHeroes(tmpset);
        tmpt2.setHeroes(tmpset2);
        tmp.setTeam(tmpt);
        tmp2.setTeam(tmpt2);
        userRepository.save(tmp);
        userRepository.save(tmp2);
        userRepository.delete(tmp);
    }


}
