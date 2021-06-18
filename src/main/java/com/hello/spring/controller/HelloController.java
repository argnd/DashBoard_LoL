package com.hello.spring.controller;

import com.hello.spring.model.Hero;
import com.hello.spring.model.Team;
import com.hello.spring.model.User;
import com.hello.spring.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@Controller
public class HelloController {

    private final UserRepository userRepository;

    public HelloController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/hello")
    public String greet(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @PostMapping(value = "/hello")
    public String greetHim(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/test")
    public String test() {
        User tmp = new User();
        Team tmpt = new Team();
        Hero tmph = new Hero();
        List<Hero> tmpset = new ArrayList<>();
        tmpset.add(tmph);
        tmpset.add(tmph);
        tmpset.add(tmph);
        tmpset.add(tmph);
        tmp.setUsername("Hello");
        tmpt.setHeroes(tmpset);
        tmp.setTeam(tmpt);

        userRepository.save(tmp);
        return "hello";
    }

}
