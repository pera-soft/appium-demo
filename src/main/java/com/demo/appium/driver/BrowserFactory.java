package com.demo.appium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static com.demo.appium.config.ConfigurationManager.configuration;
import static java.lang.Boolean.TRUE;

public enum BrowserFactory {
    CHROME {
        @Override
        public WebDriver createLocalDriver() {
            WebDriverManager.chromedriver().setup();

            return new ChromeDriver(getOptions());
        }

        @Override
        public WebDriver createDriver() {
            return new ChromeDriver();
        }

        @Override
        public ChromeOptions getOptions() {
            var chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(configuration().startMaximized());
            chromeOptions.addArguments(configuration().disableInfoBars());
            chromeOptions.addArguments(configuration().disableNotifications());
            chromeOptions.setHeadless(configuration().headless());

            return chromeOptions;
        }

    },

    FIREFOX {
        @Override
        public WebDriver createLocalDriver() {
            WebDriverManager.firefoxdriver().setup();

            return new FirefoxDriver(getOptions());
        }

        @Override
        public WebDriver createDriver() {
            return new FirefoxDriver(getOptions());
        }

        @Override
        public FirefoxOptions getOptions() {
            var firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments(configuration().startMaximized());
            firefoxOptions.setHeadless(configuration().headless());

            return firefoxOptions;
        }

    },

    EDGE {
        @Override
        public WebDriver createLocalDriver() {
            WebDriverManager.edgedriver().setup();

            return new EdgeDriver(getOptions());
        }

        @Override
        public WebDriver createDriver() {
            return new EdgeDriver(getOptions());
        }

        @Override
        public EdgeOptions getOptions() {
            var edgeOptions = new EdgeOptions();
            edgeOptions.addArguments(configuration().startMaximized());
            edgeOptions.setHeadless(configuration().headless());

            return edgeOptions;
        }

    },

    SAFARI {
        @Override
        public WebDriver createLocalDriver() {
            WebDriverManager.safaridriver().setup();

            return new SafariDriver(getOptions());
        }

        @Override
        public WebDriver createDriver() {
            return new SafariDriver(getOptions());
        }

        @Override
        public SafariOptions getOptions() {
            var safariOptions = new SafariOptions();
            safariOptions.setAutomaticInspection(false);

            if (TRUE.equals(configuration().headless()))
                throw new RuntimeException(safariOptions.getBrowserName());

            return safariOptions;
        }

    };

    public abstract WebDriver createLocalDriver();

    public abstract WebDriver createDriver();

    public abstract AbstractDriverOptions<?> getOptions();
}