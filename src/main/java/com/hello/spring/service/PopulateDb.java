package com.hello.spring.service;

import com.hello.spring.model.Hero;
import com.hello.spring.model.Team;
import com.hello.spring.model.User;
import com.hello.spring.repository.HeroRepository;
import com.hello.spring.repository.TeamRepository;
import com.hello.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class PopulateDb {

    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final HeroRepository heroRepository;

    @Autowired
    public PopulateDb(UserRepository userRepository, TeamRepository teamRepository, HeroRepository heroRepository) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.heroRepository = heroRepository;
    }

    public User populate(String username) {
        //CREATE USER
        User user = new User();
        user.setAvatar("LIEN VERS MON AVATAR");
        user.setEmail("Hello@world.com");
        user.setUsername("noobmaster_420");
        user.setPassword("hunter2");
        user.setSummoner("Kez37");
        user.setWallpaper("LIEN VERS MON FOND ECRAN");

        //CREATE HEROES
        Hero tmph = new Hero();
        Hero tmph1 = new Hero();
        Hero tmph2 = new Hero();
        Hero tmph3 = new Hero();
        Hero tmph4 = new Hero();
        //
        tmph.setName("Sion");
        tmph.setCharm(0);
        tmph.setTbd(99);
        tmph.setPicture("LIEN VERS MA PHOTO");
        //
        tmph1.setName("Miss Fortune");
        tmph1.setCharm(99);
        tmph1.setTbd(30);
        tmph1.setPicture("LIEN VERS MA PHOTO");
        //
        tmph2.setName("Rammus");
        tmph2.setCharm(30);
        tmph2.setTbd(30);
        tmph2.setPicture("LIEN VERS MA PHOTO");
        //
        tmph3.setName("Amumu");
        tmph3.setCharm(50);
        tmph3.setTbd(15);
        tmph3.setPicture("LIEN VERS MA PHOTO");
        //
        tmph4.setName("Teemo");
        tmph4.setCharm(85);
        tmph4.setTbd(5);
        tmph4.setPicture("JE SUIS UN DEMON");
        //Create Team
        Team team = new Team();
        List<Hero> tmpset = new ArrayList<>();
        tmpset.add(tmph);
        tmpset.add(tmph1);
        tmpset.add(tmph2);
        tmpset.add(tmph3);
        tmpset.add(tmph4);
        team.setHeroes(tmpset);

        //Affecter la team au user
        user.setTeam(team);
        //Sauvegarder le user
        userRepository.save(user);
        return user;
    }

}
