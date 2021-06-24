package com.hello.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getWelcome() {
        return "/welcome";
    }

    @PostMapping("/home")
    public String Login(@RequestParam String name, HttpSession session) {
        session.setAttribute("name", name);
        return "layouts/home";
    }

    @GetMapping("/home")
    public String gethome() {
        return "layouts/home";
    }

}
