package com.cuscatlan.paymentservice.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuscatlan.paymentservice.application.dtos.LoginRequest;
import com.cuscatlan.paymentservice.application.services.LoginService;


@RestController
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String postMethodName(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }
    
}
