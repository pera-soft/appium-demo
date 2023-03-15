package com.demo.appium.data;

import com.demo.appium.model.Login;

import static com.demo.appium.config.ConfigurationManager.configuration;

public class LoginPageData {

    private LoginPageData() {
    }

    public static Login getLoginData() {
        return new Login(configuration().loginPageUsername(), configuration().loginPagePassword());
    }

}