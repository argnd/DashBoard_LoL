package com.hello.spring.controller;

import com.hello.spring.model.User;
import com.hello.spring.service.FightService;
import com.hello.spring.service.ManageTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@Controller
public class ManageTeam {

    private final ManageTeamService manageTeamService;

    @Autowired
    public ManageTeam(ManageTeamService manageTeamService) {
        this.manageTeamService = manageTeamService;
    }

    @GetMapping("/manage-team")
    public String manageTeam() {
        return "layouts/manageteam/home";
    }
}
