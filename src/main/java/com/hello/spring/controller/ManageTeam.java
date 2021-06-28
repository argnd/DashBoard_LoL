package com.hello.spring.controller;

import com.hello.spring.model.Hero;
import com.hello.spring.service.ManageTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ManageTeam {

    private final ManageTeamService manageTeamService;

    @Autowired
    public ManageTeam(ManageTeamService manageTeamService) {
        this.manageTeamService = manageTeamService;
    }

    @GetMapping("/manage-team")
    public String manageTeam(Model model) {
        List<Hero> heroList = manageTeamService.getAllHeroes();
        model.addAttribute("heroList", heroList);
        return "layouts/manageteam/manageteam";
    }

}
