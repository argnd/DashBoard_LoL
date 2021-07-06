package com.hello.spring.restcontroller;

import com.hello.spring.model.User;
import com.hello.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {

    private UserRepository userRepository;

    @Autowired
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/api/users")
    public Map<String,Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", userRepository.getById(1).getId());
        return model;
    }


}
