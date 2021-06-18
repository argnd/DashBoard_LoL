package com.hello.spring.controller;

import com.hello.spring.model.User;
import com.hello.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @Autowired
    private UserRepository userRepository;

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
        tmp.setUsername("Hello");
        tmp.setPassword("pass");
        tmp.setAvatar("avatar");
        tmp.setEmail("mail");
        tmp.setSummoner("sum");
        tmp.setTeamId(5);
        tmp.setWallpaper("wallpaper");
        userRepository.save(tmp);

        System.out.println(userRepository.findAll().get(0).getAvatar());
//      System.out.println(userRepository.findAll());
        return "hello";
    }

}
