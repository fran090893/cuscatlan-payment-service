package com.cuscatlan.paymentservice.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuscatlan.paymentservice.application.dtos.LoginRequest;
import com.cuscatlan.paymentservice.infrastructure.repositories.UserIntegration;

@Service
public class LoginService {
    @Autowired
    private UserIntegration userIntegration;

    public String login(LoginRequest loginRequest){
        return  userIntegration.login(loginRequest.GetUserName(), loginRequest.Getpassword());
    }
}
