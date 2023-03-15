package com.demo.appium.driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static final ThreadLocal<WebDriver> mobileDriver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        return webDriver.get();
    }

    public static WebDriver getMobileDriver() {
        return mobileDriver.get();
    }

    public static void setWebDriver(WebDriver webDriver) {
        DriverManager.webDriver.set(webDriver);
    }

    public static void setMobileDriver(WebDriver webDriver) {
        DriverManager.mobileDriver.set(webDriver);
    }

    public static void quit() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }

        if (mobileDriver.get() != null) {
            mobileDriver.get().quit();
            mobileDriver.remove();
        }
    }

    public static String getWebInfo() {
        var capabilities = ((RemoteWebDriver) DriverManager.getWebDriver()).getCapabilities();
        String browserName = capabilities.getBrowserName();
        String platform = capabilities.getPlatformName().name();
        String version = capabilities.getBrowserVersion();

        return String.format("browser: %s version: %s platform: %s", browserName, version, platform);
    }

    public static String getMobileInfo() {
        var capabilities = ((AndroidDriver) DriverManager.getMobileDriver()).getCapabilities();
        String browserName = capabilities.getBrowserName();
        String platform = capabilities.getPlatformName().name();
        String version = capabilities.getBrowserVersion();

        return String.format("mobile: %s version: %s platform: %s", browserName, version, platform);
    }
}