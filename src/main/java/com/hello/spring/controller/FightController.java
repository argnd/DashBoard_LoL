package com.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FightController {

    @GetMapping("/combat")
    public String getFight() {



        return "layouts/fight/fighthome";
    }




}
