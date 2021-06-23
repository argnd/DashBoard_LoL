package com.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfilController {
    @GetMapping("/profile")
    public String getProfil() {
        return "layouts/profile/profile";
    }
}
