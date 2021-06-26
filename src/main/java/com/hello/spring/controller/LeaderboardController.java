package com.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LeaderboardController {

    @GetMapping("/leaderboard")
    public String getLeaderBoard() {
        return "layouts/leaderboard/leaderboard";
    }

}
