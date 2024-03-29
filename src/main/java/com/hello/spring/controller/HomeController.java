package com.hello.spring.controller;


import com.hello.spring.service.PopulateDbService;
import com.hello.spring.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class HomeController {

    private final PopulateDbService populateDbService;

    @Autowired
    public HomeController(PopulateDbService populateDbService) {
        this.populateDbService = populateDbService;
    }

    @GetMapping("/")
    public String getWelcome() {
        return "welcome";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/oauthlogin")
    public String oauthLogin(){
        return "oauthlogin";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("logout","");
        return "login";
    }

    @GetMapping("/home")
    public String gethome(HttpSession session, Principal principal, Authentication authentication){
        User currentUser = populateDbService.getUserByUserName(principal.getName());

        session.setAttribute("user", currentUser);

        System.out.println(principal.getClass().getName());
        System.out.println(principal.toString());

        return "layouts/home";
    }



}
