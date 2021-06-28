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
public class PopulateDbService {

    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final HeroRepository heroRepository;

    @Autowired
    public PopulateDbService(UserRepository userRepository, TeamRepository teamRepository, HeroRepository heroRepository) {
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
        tmph.setName("Ahri");
        tmph.setCharm(0);
        tmph.setTbd(99);
        tmph.setPicture("LIEN VERS MA PHOTO");
        //
        tmph1.setName("MissFortune");
        tmph1.setCharm(99);
        tmph1.setTbd(30);
        tmph1.setPicture("LIEN VERS MA PHOTO");
        //
        tmph2.setName("Ashe");
        tmph2.setCharm(30);
        tmph2.setTbd(30);
        tmph2.setPicture("LIEN VERS MA PHOTO");
        //
        tmph3.setName("Seraphine");
        tmph3.setCharm(50);
        tmph3.setTbd(15);
        tmph3.setPicture("LIEN VERS MA PHOTO");
        //
        tmph4.setName("Evelynn");
        tmph4.setCharm(85);
        tmph4.setTbd(5);
        tmph4.setPicture("JE SUIS UN DEMON");
        //Create Team
        heroRepository.save(tmph);
        heroRepository.save(tmph1);
        heroRepository.save(tmph2);
        heroRepository.save(tmph3);
        heroRepository.save(tmph4);
        Team team = new Team();
        Team team2 = new Team();
        List<Hero> tmpset = new ArrayList<>();
        tmpset.add(tmph);
        tmpset.add(tmph1);
        tmpset.add(tmph2);
        tmpset.add(tmph3);
        tmpset.add(tmph4);
        team.setHeroes(tmpset);
        team2.setHeroes(tmpset);
        //Affecter la team au user
        user.setTeam(team);
        //Sauvegarder le user
        userRepository.save(user);
        User bob = new User();
        bob.setTeam(team2);
        bob.setUsername("NoobMaster69");
        userRepository.save(bob);
        User bob2 = userRepository.getById(2);
        return user;
    }

}
