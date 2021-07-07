package com.hello.spring.controller;

import com.hello.spring.model.User;
import com.hello.spring.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class FightController {

    FightService fightService;

    @Autowired
    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    @GetMapping("/combat")
    public String getFight(Model model) {
        List<User> userList = Arrays.asList(fightService.pickThreeUser());
        model.addAttribute("userList",userList);
        return "layouts/fight/fight";
    }

    @GetMapping("/combat-oppponent-selected")
    public String chooseOpponent(@RequestParam int id, Model model) {
        User choosenOpponent = fightService.getUserById(id);
        model.addAttribute("choosenOpponent",choosenOpponent);
        return "layouts/fight/opponentselected";
    }

    @GetMapping("/combat-oppponent-validated")
    public String doFight(@RequestParam int id, Model model, HttpSession httpSession) {
        User choosenOpponent = fightService.getUserById(id);
        User currentUser =(User) httpSession.getAttribute("user");

        boolean didIWin = fightService.compareUserCharm(currentUser,choosenOpponent);
        model.addAttribute("didIWin",didIWin);

        return "layouts/fight/result";
    }

}
