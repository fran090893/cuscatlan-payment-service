package com.cuscatlan.paymentservice.infrastructure.dtos;

public class UserDTO {
    private Long id;
    private String email;
    private String username;
    private String password;

    public UserDTO(){}

    public Long getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public String getUserName(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
