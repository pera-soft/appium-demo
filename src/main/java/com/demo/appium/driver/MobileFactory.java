package com.demo.appium.driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static com.demo.appium.config.ConfigurationManager.configuration;

public enum MobileFactory {

    ANDROİD {
        @Override
        public WebDriver createDriver() throws MalformedURLException {
            return new AndroidDriver(new URL(configuration().serverAddress()), getOptions());
        }

        @Override
        public DesiredCapabilities getOptions() {
            var caps = new DesiredCapabilities();
            caps.setCapability("deviceName", configuration().deviceName());
            caps.setCapability("udid", configuration().udid());
            caps.setCapability("automationName", configuration().automationName());
            caps.setCapability("platformName", configuration().platformName());
            caps.setCapability("platformVersion", configuration().platformVersion());
            caps.setCapability("appPackage", configuration().appPackage());
            caps.setCapability("appActivity", configuration().appActivity());

            return caps;
        }

    };

    public abstract WebDriver createDriver() throws MalformedURLException;

    public abstract DesiredCapabilities getOptions();
}