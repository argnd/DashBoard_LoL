package com.hello.spring.populatedb;

import com.hello.spring.model.Hero;
import com.hello.spring.model.Team;
import com.hello.spring.model.User;
import com.hello.spring.repository.HeroRepository;
import com.hello.spring.repository.TeamRepository;
import com.hello.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;

public class populatedb implements CommandLineRunner {

    private final HeroRepository heroRepository;
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

        @Autowired
    public populatedb(HeroRepository heroRepository, TeamRepository teamRepository, UserRepository userRepository) {
        this.heroRepository = heroRepository;
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //CREATE USER
        User User = new User();
        User.setAvatar("LIEN VERS MON AVATAR");
        User.setUsername("MON NOM");
        User.setPassword("hunter2");
        User.setSummoner("Kez37");
        User.setWallpaper("LIEN VERS MON FOND ECRAN");

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

        //Affecter la team au User
        User.setTeam(team);
        //Sauvegarder le User
        userRepository.save(User);
    }

}
