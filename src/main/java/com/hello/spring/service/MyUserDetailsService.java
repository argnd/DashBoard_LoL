package com.hello.spring.service;

import com.hello.spring.dto.MyUserDetails;
import com.hello.spring.model.User;
import com.hello.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> user = userRepository.findUserByUsername(username);
       user.orElseThrow(() -> new UsernameNotFoundException("User Not foud: " + username));
       return user.map(MyUserDetails::new).get();
    }
}
