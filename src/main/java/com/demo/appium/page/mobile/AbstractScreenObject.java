package com.demo.appium.page.mobile;

import com.demo.appium.driver.DriverManager;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static com.demo.appium.config.ConfigurationManager.configuration;
import static org.openqa.selenium.support.PageFactory.initElements;

public class AbstractScreenObject {

    protected AbstractScreenObject() {
        initElements(new AjaxElementLocatorFactory(DriverManager.getMobileDriver(), configuration().timeout()), this);
    }

}