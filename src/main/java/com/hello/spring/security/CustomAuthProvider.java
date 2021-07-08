package com.hello.spring.security;


import com.hello.spring.dto.MyUserDetails;
import com.hello.spring.model.User;
import com.hello.spring.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    MyUserDetailsService myUserDetailsService;

    @Autowired
    public CustomAuthProvider(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication auth)
            throws AuthenticationException {

        List<SimpleGrantedAuthority> l = new ArrayList<>();
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        l.add(grantedAuthority);
        String username = auth.getName();
        String password = auth.getCredentials()
                .toString();

        if ("noobmaster_420".equals(username) && "coucou".equals(password)) {
            MyUserDetails user =(MyUserDetails) myUserDetailsService.loadUserByUsername(username);
            return new UsernamePasswordAuthenticationToken(user,password,l);
        } else {
            throw new
                    BadCredentialsException("External system authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }

}
