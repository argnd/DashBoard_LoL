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

    public static final String[] specialNames = new String[]
            {"DUMMY","Kai'Sa","Cho'Gath","Kha'Zix","Vel'Koz","LeBlanc","Wukong","Nunu & Willump"};
    public static final String baseLink = "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/";
    public static final String skinId ="_0.jpg";

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

        //DUMMY HERO IS DEFAULT VALUE OF TEAM
        Hero DUMMY_HERO = new Hero();
        DUMMY_HERO.setName("DUMMY");
        DUMMY_HERO.setDescritpion("DUMMY");
        DUMMY_HERO.setPicture("DUMMY");
        DUMMY_HERO.setCharm(0);
        DUMMY_HERO.setTbd(0);
        heroRepository.save(DUMMY_HERO);

        for (Map.Entry<String,ChampionData> m: championDataMap.entrySet() ) {
            Hero tmphHero = new Hero();

            String heroName = m.getValue().getName();
            if (insntSpecial(heroName)) {
                String link = String.valueOf(m.getValue().getName())
                        .replaceAll("[^a-zA-Z0-9]", " ")
                        .replace(" ","")
                        +skinId;
                tmphHero.setPicture(baseLink+link);
            } else{
                String link = specialNameLinkGenerator(heroName);
                tmphHero.setPicture(link);
            }

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

    //Create 5 user, one whose name is the value of the form
    public User populate(String username) {
        //CREATE USER
        User user = new User();
        user.setAvatar("LIEN VERS MON AVATAR");
        user.setEmail("Hello@world.com");
        user.setUsername(username);
        user.setPassword("hunter2");
        user.setSummoner("Kez37");
        user.setWallpaper("LIEN VERS MON FOND ECRAN");

        Team team = new Team();
        Team team2 = new Team();
        Team team3 = new Team();
        Team team4 = new Team();
        Team team5 = new Team();

        List<Hero> tmpset = new ArrayList<>();
        tmpset.add(heroRepository.findByName("DUMMY"));
        tmpset.add(heroRepository.findByName("DUMMY"));
        tmpset.add(heroRepository.findByName("DUMMY"));
        tmpset.add(heroRepository.findByName("DUMMY"));
        tmpset.add(heroRepository.findByName("DUMMY"));
        team.setHeroes(tmpset);
        team2.setHeroes(tmpset);
        team3.setHeroes(tmpset);
        team4.setHeroes(tmpset);
        team5.setHeroes(tmpset);

        user.setTeam(team);
        userRepository.save(user);

        User bob = new User();
        bob.setTeam(team2);
        bob.setUsername("NoobMaster_69");
        userRepository.save(bob);

        User ross = new User();
        ross.setTeam(team3);
        ross.setUsername("jojo");
        userRepository.save(ross);

        User arg = new User();
        arg.setTeam(team4);
        arg.setUsername("ARG");
        userRepository.save(arg);

        User ysf = new User();
        ysf.setTeam(team5);
        ysf.setUsername("YSF");
        userRepository.save(ysf);

        return user;
    }

    private boolean insntSpecial(String name){
        boolean sp = true;
        for (int i = 0; i < specialNames.length; i++) {
            if(specialNames[i].equals(name)){
                sp = false;
            }
        }
        return sp;
    }

    private String specialNameLinkGenerator(String name){
        StringBuilder link = new StringBuilder();
        switch(name) {
            case "DUMMY":
                link.append("DUMMUY.jpg");
                break;
            case "Kai'Sa":
                link.append(baseLink+"Kaisa"+skinId);
                break;
            case "Cho'Gath":
                link.append(baseLink+"Chogath"+skinId);
                break;
            case "Kha'Zix":
                link.append(baseLink+"Khazix"+skinId);
                break;
            case "Vel'Koz":
                link.append(baseLink+"Velkoz"+skinId);
                break;
            case "LeBlanc":
                link.append(baseLink+"Leblanc"+skinId);
                break;
            case "Nunu & Willump":
                link.append(baseLink+"Nunu"+skinId);
                break;
            case "Wukong":
                link.append(baseLink+"MonkeyKing"+skinId);
                break;
        }
        return link.toString();
    }

}
