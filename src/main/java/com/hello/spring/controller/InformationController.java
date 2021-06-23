package com.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InformationController {

    @GetMapping("/contact")
    public String getContact() {
        return "layouts/information/contact";
    }

    @GetMapping("/a-propos")
    public String getAbout() {
        return "layouts/information/about";
    }

    @GetMapping("/aide")
    public String getHelp() {
        return "layouts/information/help";
    }
    @GetMapping("/mentions")
    public String getMentions() {
        return "layouts/information/mentions";
    }
}
