package com.javi.uned.pfgbackend.domain.user;

import com.javi.uned.pfgbackend.config.JWTAuthorizationFilter;
import com.javi.uned.pfgbackend.domain.user.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;
import java.util.stream.Collectors;

public class TokenFactory {

    private TokenFactory() {

    }

    public static String authToken(Authentication authentication, User user) {

        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        String token = Jwts.builder()
                .setId("auth-token")
                .setSubject(authentication.getName())
                .claim("id", user.getId())
                .claim("name", user.getName())
                .claim("surname", user.getSurname())
                .claim("email", user.getEmail())
                .claim("authorities", authorities)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, JWTAuthorizationFilter.SECRET.getBytes())
                .compact();
        return JWTAuthorizationFilter.PREFIX + token;
    }

    public static String personalToken(User user, long duration) {

        String authorities = user.getRoles().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        String token = Jwts.builder()
                .setId("personal-token")
                .claim("id", user.getId())
                .claim("authorities", authorities)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + duration))
                .signWith(SignatureAlgorithm.HS512, JWTAuthorizationFilter.SECRET.getBytes())
                .compact();
        return JWTAuthorizationFilter.PREFIX + token;

    }
}
