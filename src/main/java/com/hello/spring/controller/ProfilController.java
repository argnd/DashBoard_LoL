package com.hello.spring.controller;

import com.hello.spring.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfilController {

    SecurityService securityService;

    @Autowired
    public ProfilController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/profile")
    public String getProfil() {
        return "layouts/profile/profile";
    }

    @GetMapping("/jwt")
    public String getJwt(Model model) {
        String key  = securityService.getKey();
        model.addAttribute("key",key);
        return "layouts/profile/jwtkey";
    }

}
