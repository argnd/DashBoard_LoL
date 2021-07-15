package com.hello.spring.controller;

import com.hello.spring.model.Hero;
import com.hello.spring.model.Team;
import com.hello.spring.model.User;
import com.hello.spring.repository.HeroRepository;
import com.hello.spring.repository.UserRepository;
import com.hello.spring.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SignupController {



    @Autowired
    SecurityService securityService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    HeroRepository heroRepository;


    @GetMapping("/signup")
    public String getSignup() {
        return "layouts/signup/signup";
    }

    @GetMapping("/signed")
    public String getSigned() {
        return "layouts/signup/login";
    }

    @PostMapping("/signed")
    public String getRegistered(@RequestParam("username") String name,@RequestParam("password") String password,@RequestParam("mail") String mail){
        User user = new User();
        user.setEmail(mail);
        user.setUsername(name);
        user.setPassword(password);
        user.setActive(true);
        user.setRoles("ROLE_USER");
        Team team = new Team();
        List<Hero> Heroes = new ArrayList<>();
        Heroes.add(heroRepository.findByName("DUMMY"));
        Heroes.add(heroRepository.findByName("DUMMY"));
        Heroes.add(heroRepository.findByName("DUMMY"));
        Heroes.add(heroRepository.findByName("DUMMY"));
        Heroes.add(heroRepository.findByName("DUMMY"));
        team.setHeroes(Heroes);
        user.setTeam(team);


         userRepository.save(user);


    return "redirect:/login";



    }
}
