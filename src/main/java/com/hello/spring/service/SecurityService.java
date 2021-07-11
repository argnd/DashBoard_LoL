package com.hello.spring.service;

import com.hello.spring.dto.MyUserDetails;
import com.hello.spring.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    JwtUtils jwtUtils;

    @Autowired
    public SecurityService(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    public String getKey(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String jwt = jwtUtils.generateJwtToken(auth);
        return jwt;
    }

    public String getUserKey(MyUserDetails user){
        String jwt = jwtUtils.generateJwtTokenFromValidUserDetails(user);
        return jwt;
    }

}
