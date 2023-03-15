package com.demo.appium;

import com.demo.appium.driver.DriverManager;
import com.demo.appium.driver.MobileFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;

import static com.demo.appium.config.ConfigurationManager.configuration;
import static com.demo.appium.driver.BrowserFactory.valueOf;

@Listeners({TestListener.class})
public abstract class BaseTest {

    @BeforeMethod(onlyForGroups = {"Panel"})
    @Parameters("browser")
    public void preConditionForPanel(@Optional("chrome") String browser) {
        WebDriver driver = valueOf(configuration().browser().toUpperCase()).createLocalDriver();
        DriverManager.setWebDriver(driver);

        DriverManager.getWebDriver().get(configuration().url());
    }

    @AfterMethod(onlyForGroups = {"Panel"})
    public void postConditionForPanel() {
        DriverManager.quit();
    }

    @BeforeMethod(onlyForGroups = {"App"})
    @Parameters("platform")
    public void preCondition(@Optional("android") String platform) throws MalformedURLException {
        WebDriver driver = MobileFactory.valueOf(configuration().platformName().toUpperCase()).createDriver();
        DriverManager.setMobileDriver(driver);
    }

    @AfterMethod(onlyForGroups = {"App"})
    public void postCondition() {
        DriverManager.quit();
    }

    @SneakyThrows
    public void sleep(int duration) {
        Thread.sleep(Duration.ofSeconds(duration).toMillis());
    }

}