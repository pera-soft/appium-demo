package com.demo.appium.page.web;

import com.demo.appium.data.LoginPageData;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPageObject {

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"kt_login_signin_form\"]/div[4]/button")
    private WebElement button;

    @Step
    public void fillUsername(String username) {
        this.username.sendKeys(username);
    }

    @Step
    public void fillPassword(String password) {
        this.password.sendKeys(password);
    }

    @Step
    public void clickButton() {
        button.click();
    }

    @Story("login")
    public void login() {
        var loginData = LoginPageData.getLoginData();

        var loginPage = new LoginPage();
        loginPage.fillUsername(loginData.getUsername());
        loginPage.fillPassword(loginData.getGetPassword());
        loginPage.clickButton();
    }

}