package com.hello.spring;


import com.hello.spring.dto.championdata.ChampionDataWrapper;
import com.hello.spring.repository.UserRepository;
import com.hello.spring.service.PopulateDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@SuppressWarnings("all")
public class HelloSpringApplication {

    @Autowired
    PopulateDbService populateDbService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloSpringApplication.class, args);
    }

//    //Create hero list on db startup
//    @Bean
//    public CommandLineRunner run() throws Exception {
//        return args -> {
//            RestTemplate r = new RestTemplate();
//            ChampionDataWrapper resp = r.getForObject(
//                    "http://ddragon.leagueoflegends.com/cdn/11.13.1/data/en_US/champion.json",
//                    ChampionDataWrapper.class);
//            populateDbService.createHeroes(resp.getData());
//        };
//    }

}
