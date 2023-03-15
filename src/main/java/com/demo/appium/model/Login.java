package com.demo.appium.model;

import lombok.Data;

@Data
public class Login {

    public Login(String username, String getPassword) {
        this.username = username;
        this.getPassword = getPassword;
    }

    private String username;

    private String getPassword;

}