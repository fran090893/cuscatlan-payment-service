package com.cuscatlan.paymentservice.infrastructure.repositories;

import java.security.Key;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cuscatlan.paymentservice.infrastructure.dtos.LoginResponseDTO;
import com.cuscatlan.paymentservice.infrastructure.dtos.UserDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class UserIntegration implements UserDetailsService{

    private final RestTemplate restTemplate;
    private static final String FAKE_STORE_LOGIN_URL = "https://fakestoreapi.com/auth/login";
    private static final String FAKE_STORE_GET_USER = "https://fakestoreapi.com/users/";
    private final Key secretKey;

    @Value("${jwt.secret}")
    private String secret;

    public UserIntegration(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        this.secretKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
    }

    public String login(String username, String password) {
        Map<String, String> loginData = new HashMap<>();
        loginData.put("username", username);
        loginData.put("password", password);


        HttpEntity<Map<String, String>> request = new HttpEntity<>(loginData);

        LoginResponseDTO response = restTemplate.exchange(
            FAKE_STORE_LOGIN_URL,
            HttpMethod.POST,
            request,
            LoginResponseDTO.class
        ).getBody();

        if (response != null && response.getToken() != null) {
            return response.getToken();
        } else {
            throw new RuntimeException("Invalid login credentials");
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);
            return true; 
        } catch (Exception e) {
            return false; 
        }
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public UserDetails loadUserByUsername(String id) {
        UserDTO user = restTemplate.getForObject(FAKE_STORE_GET_USER+id.toString(), UserDTO.class);
        return User.withUsername(user.getUserName())
                .password(user.getPassword()) 
                .authorities("") 
                .build();
    }
}
