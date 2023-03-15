package com.demo.appium.test;

import com.demo.appium.BaseTest;
import com.demo.appium.driver.DriverManager;
import com.demo.appium.page.mobile.HomeScreen;
import com.demo.appium.page.mobile.StartScreen;
import com.demo.appium.page.mobile.WelcomeScreen;
import com.demo.appium.page.web.LoginPage;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class MainTest extends BaseTest {

    @SneakyThrows()
    @Test(description = "First category check on mobile", priority = 1, groups = {"App"})
    public void firstCheckOnMobile() {
        var startScreen = new StartScreen();
        startScreen.clickButton();

        sleep(3);

        var welcomeScreen = new WelcomeScreen();
        welcomeScreen.clickButton();

        sleep(5);

        var homeScreen = new HomeScreen();
        homeScreen.getCategoryNames();

        assertTrue(homeScreen.checkCategory("Glütensiz"));
    }

    @SneakyThrows
    @Test(description = "Edit category status on panel", priority = 2, groups = {"Panel"})
    public void editCategoryOnPanel() {
        var driver = DriverManager.getWebDriver();
        var wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        var loginPage = new LoginPage();
        loginPage.login();

        sleep(10);

        WebElement categories = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"kt_aside_menu\"]/div/ul/li[4]")));
        categories.click();

        sleep(5);

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,500)", "");

        WebElement pageTwo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/ul/li[3]")));
        pageTwo.click();

        String gluten = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div/div[2]/div[1]/table/tbody/tr[8]/td[3]/a"))).getText();
        if (gluten.contains("Glütensiz")) {
            WebElement editButton = driver.findElement(By.cssSelector("#app > div.v-application--wrap > div.card.card-custom.gutter-b.categoryListPage > div.card-body > div > div.row > div > div.v-data-table.categoryListTable.theme--light > div.v-data-table__wrapper > table > tbody > tr:nth-child(8) > td:nth-child(6) > button > span.btn.btn-icon.btn-sm.btn-light-primary.mr-2 > i"));
            editButton.click();

            sleep(3);

            jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

            WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#kt_content > div.d-flex.flex-column-fluid > div > div > div.container > div.card.card-custom > div.card-body > div:nth-child(7) > div.col-lg-10 > span > label > span")));
            checkbox.click();

            sleep(1);

            WebElement saveButton = driver.findElement(By.cssSelector("#kt_content > div.d-flex.flex-column-fluid > div > div > div.container > div.card.card-custom > div.card-body > div.float-right > button.btn.btn-light-danger.py-3.px-5"));
            saveButton.click();

            sleep(1);

            WebElement accept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#kt_content > div.d-flex.flex-column-fluid > div > div > div.container > div.v-dialog__container > div > div > div > div.v-card__actions > button.btn.btn-light-danger.py-2.px-8")));
            accept.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div > div.card.card-custom.gutter-b.categoryListPage > div.card-header > div > h3")));
        }
    }

    @SneakyThrows
    @Test(description = "Second category check on mobile", priority = 3, groups = {"App"})
    public void secondCheckOnMobile() {

        var startScreen = new StartScreen();
        startScreen.clickButton();

        sleep(3);

        var welcomeScreen = new WelcomeScreen();
        welcomeScreen.clickButton();

        sleep(5);

        var homeScreen = new HomeScreen();
        homeScreen.getCategoryNames();

        assertFalse(homeScreen.checkCategory("Glütensiz"));
    }

}