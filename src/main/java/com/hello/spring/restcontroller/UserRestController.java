package com.hello.spring.restcontroller;

import com.hello.spring.dto.MyUserDetails;
import com.hello.spring.model.User;
import com.hello.spring.repository.UserRepository;
import com.hello.spring.service.MyUserDetailsService;
import com.hello.spring.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {

    private final UserRepository userRepository;
    private final SecurityService securityService;
    private final MyUserDetailsService myUserDetailsService;

    @Autowired
    public UserRestController(UserRepository userRepository, SecurityService securityService, MyUserDetailsService myUserDetailsService) {
        this.userRepository = userRepository;
        this.securityService = securityService;
        this.myUserDetailsService = myUserDetailsService;
    }

    @GetMapping("/api/users")
    public List<User> home() {
        return userRepository.findAll();
    }

    @PostMapping("/loginapi")
    public String login(@RequestParam("userName")String username,@RequestParam("password")String password) {
        String token =
                securityService.getUserKey
                        ((MyUserDetails) myUserDetailsService.tryToLoadUserByUsername(username,password));
        return token;
    }


}
