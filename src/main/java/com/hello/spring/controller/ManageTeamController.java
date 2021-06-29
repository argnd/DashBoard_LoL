package com.hello.spring.controller;

import com.hello.spring.model.Hero;
import com.hello.spring.service.ManageTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ManageTeamController {

    private final ManageTeamService manageTeamService;

    @Autowired
    public ManageTeamController(ManageTeamService manageTeamService) {
        this.manageTeamService = manageTeamService;
    }

    @GetMapping("/manage-team")
    public String manageTeam(Model model) {
        List<Hero> heroList = manageTeamService.getAllHeroes();
        model.addAttribute("heroList", heroList);
        return "layouts/manageteam/manageteam";
    }

    @GetMapping("/add-hero")
    public String addHero(@RequestParam Integer id,Model model, HttpSession session) {
        model.addAttribute("hero", manageTeamService.getById(id));
        model.addAttribute("canAdd",manageTeamService.canUserAddHero(id,session));
        System.out.println(manageTeamService.canUserAddHero(id,session));
        return "layouts/manageteam/newheroselected";
    }

    @GetMapping("/add-hero-validated")
    public String addHeroValidated(@RequestParam Integer id, HttpSession session) {
        manageTeamService.addHeroToUser(id, session);
        return "redirect:/manage-team";
    }

    @GetMapping("/remove-hero")
    public String removeHero(@RequestParam Integer id,HttpSession session) {
        manageTeamService.removeHeroFromUser(id, session);
        return "redirect:/manage-team";
    }

}
