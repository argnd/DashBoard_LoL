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
        return "hello";
    }

}
