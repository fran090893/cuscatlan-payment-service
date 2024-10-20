package com.cuscatlan.paymentservice.application.dtos;

import javax.validation.constraints.NotNull;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotNull(message = "Username is required")
    @NotBlank(message = "Username is required")
    private String userName;
    @NotNull(message = "Password cant be null")
    @NotBlank(message = "Password is required")
    private String password;

    //constructor
    public LoginRequest(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String GetUserName(){
        return userName;
    }

    public String Getpassword(){
        return password;
    }
}
