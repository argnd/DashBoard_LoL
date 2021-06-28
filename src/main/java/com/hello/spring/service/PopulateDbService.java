package com.hello.spring.service;

import com.hello.spring.model.Hero;
import com.hello.spring.model.Team;
import com.hello.spring.model.User;
import com.hello.spring.pojo.championdata.ChampionData;
import com.hello.spring.repository.HeroRepository;
import com.hello.spring.repository.TeamRepository;
import com.hello.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class PopulateDbService {

    private String[] excptns = new String[]{"Cho'Gath"};
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final HeroRepository heroRepository;

    @Autowired
    public PopulateDbService(UserRepository userRepository, TeamRepository teamRepository, HeroRepository heroRepository) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.heroRepository = heroRepository;
    }

    public void createHeroes(Map<String, ChampionData> championDataMap){
        for (Map.Entry<String,ChampionData> m: championDataMap.entrySet() ) {
            Hero tmphHero = new Hero();
            String link = String.valueOf(m.getValue().getName())
                    .replaceAll("[^a-zA-Z0-9]", " ")
                    .replace(" ","")
                    +"_0.jpg";
            tmphHero.setPicture("http://ddragon.leagueoflegends.com/cdn/img/champion/splash/"+link);

            Random r = new Random();
            int low = 1;
            int high = 100;
            int result = r.nextInt(high-low) + low;

            tmphHero.setCharm(result);
            tmphHero.setName(m.getValue().getName());
            tmphHero.setTbd(m.getValue().getInfo().getAttack());
            tmphHero.setDescritpion(m.getValue().getBlurb());
            heroRepository.save(tmphHero);

        }
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

        Team team = new Team();
        Team team2 = new Team();

        List<Hero> tmpset = new ArrayList<>();
        tmpset.add(heroRepository.findByName("Teemo"));
        tmpset.add(heroRepository.findByName("Amumu"));
        tmpset.add(heroRepository.findByName("Rammus"));
        tmpset.add(heroRepository.findByName("Garen"));
        tmpset.add(heroRepository.findByName("Lulu"));
        team.setHeroes(tmpset);
        team2.setHeroes(tmpset);

        user.setTeam(team);
        userRepository.save(user);

        User bob = new User();
        bob.setTeam(team2);
        bob.setUsername("NoobMaster_69");
        userRepository.save(bob);

        userRepository.delete(bob);
        return user;
    }

}
