package com.hello.spring.controller;


import com.hello.spring.model.User;
import com.hello.spring.service.PopulateDbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class HomeController {

    private final PopulateDbService populateDbService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @Autowired
    public HomeController(PopulateDbService populateDbService) {
        this.populateDbService = populateDbService;
    }

    @GetMapping("/")
    public String getWelcome() {
        return "/welcome";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("logout","");
        return "/login";
    }

    @GetMapping("/home")
    public String gethome(HttpSession session, Principal principal){
//        User currentUser = populateDbService.getUserByUserName(principal.getName());
//        session.setAttribute("user", currentUser);
        session.setAttribute("user", new User());
        return "layouts/home";
    }



}
