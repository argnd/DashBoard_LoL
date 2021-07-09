package com.hello.spring.service;

import com.hello.spring.dto.MyUserDetails;
import com.hello.spring.model.User;
import com.hello.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public UserDetails tryToLoadUserByUsername(String username,String password) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("User Not found: " + username));
        if(password.equals(user.get().getPassword()) ){
            return loadUserByUsername(username);
        }
        return null; //todo
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> user = userRepository.findUserByUsername(username);
       user.orElseThrow(() -> new UsernameNotFoundException("User Not found: " + username));
       return user.map(MyUserDetails::new).get();
    }
}
