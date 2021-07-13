package com.hello.spring.security;


import com.hello.spring.dto.MyUserDetails;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    private String jwtSecret = "bezKoderSecretKey";

    private int jwtExpirationMs = 86400000;

    public String generateJwtToken(Authentication authentication) {
        StringBuilder sb = new StringBuilder();
        MyUserDetails userPrincipal = (MyUserDetails) authentication.getPrincipal();
        if (authentication.getPrincipal().getClass().getName().equals("org.springframework.security.authentication.UsernamePasswordAuthenticationToken")){
            sb.append(((MyUserDetails) authentication.getPrincipal()).getUsername());
        } else { //oauth2token todo
            sb.append("noobmaster_420");
        }
        return Jwts.builder()
                .setSubject(sb.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String generateJwtTokenFromValidUserDetails(MyUserDetails myUserDetails) {
        StringBuilder sb = new StringBuilder();
        if (myUserDetails.getClass().getName().equals("org.springframework.security.authentication.UsernamePasswordAuthenticationToken")){
            sb.append(myUserDetails.getUsername());
        } else { //oauth2token todo
            sb.append("noobmaster_420");
        }
        return Jwts.builder()
                .setSubject(sb.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }


    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}