package com.hello.spring.controller;


import com.hello.spring.model.User;
import com.hello.spring.service.PopulateDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final PopulateDb populateDb;

    @Autowired
    public HomeController(PopulateDb populateDb) {
        this.populateDb = populateDb;
    }

    @GetMapping("/")
    public String getWelcome() {
        return "/welcome";
    }

    @PostMapping("/home")
    public String Login(@RequestParam String name, HttpSession session) {
        User currentUser = populateDb.populate(name);
        session.setAttribute("user", currentUser);
        return "layouts/home";
    }

    @GetMapping("/home")
    public String gethome() {
        return "layouts/home";
    }

}
