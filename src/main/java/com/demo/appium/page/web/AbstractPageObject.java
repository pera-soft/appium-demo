package com.demo.appium.page.web;

import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.demo.appium.driver.DriverManager;

import static com.demo.appium.config.ConfigurationManager.configuration;
import static org.openqa.selenium.support.PageFactory.initElements;

public class AbstractPageObject {

    protected AbstractPageObject() {
        initElements(new AjaxElementLocatorFactory(DriverManager.getWebDriver(), configuration().timeout()), this);
    }

}