package com.demo.appium.page.mobile;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomeScreen extends AbstractScreenObject {

    @FindBy(id = "com.file.filemarket:id/btn_continue")
    private WebElement continueWithoutLogin;

    @Step
    public void clickButton() {
        continueWithoutLogin.click();
    }

}