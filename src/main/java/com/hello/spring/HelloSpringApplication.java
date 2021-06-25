package com.hello.spring;


import com.hello.spring.beans.LeaguePlayer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@SpringBootApplication
@SuppressWarnings("all")
public class HelloSpringApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloSpringApplication.class, args);
    }


    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            RestTemplate r = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.set("X-Riot-Token", "RGAPI-9dc3e306-471c-4613-b952-85929d520a55");
            HttpEntity request = new HttpEntity(headers);

            ResponseEntity<LeaguePlayer> response = r.exchange(
                    "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/kez37",
                    HttpMethod.GET,
                    request,
                    LeaguePlayer.class
            );
            System.out.println(response.getBody().getName());
        };
    }

}
