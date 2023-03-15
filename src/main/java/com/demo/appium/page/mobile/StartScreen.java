package com.demo.appium.page.mobile;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartScreen extends AbstractScreenObject {

    @FindBy(id = "com.file.filemarket:id/tv_skip")
    private WebElement skipButton;

    @Step
    public void clickButton() {
        skipButton.click();
    }

}