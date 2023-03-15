package com.demo.appium.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:web.properties",
        "classpath:mobile.properties"
})
public interface Configuration extends Config {

    @Key("browser")
    String browser();

    @Key("headless")
    Boolean headless();

    @Key("url")
    String url();

    @Key("timeout")
    int timeout();

    @DefaultValue("--start-maximized")
    String startMaximized();

    @DefaultValue("--disable-infobars")
    String disableInfoBars();

    @DefaultValue("--disable-notifications")
    String disableNotifications();

    @Key("page.login.username")
    String loginPageUsername();

    @Key("page.login.password")
    String loginPagePassword();

    @Key("deviceName")
    String deviceName();

    @Key("udid")
    String udid();

    @Key("automationName")
    String automationName();

    @Key("platformName")
    String platformName();

    @Key("platformVersion")
    String platformVersion();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("serverAddress")
    String serverAddress();

}