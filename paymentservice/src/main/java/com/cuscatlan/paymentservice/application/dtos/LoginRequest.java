package com.cuscatlan.paymentservice.application.dtos;

public class LoginRequest {
    private String userName;
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
