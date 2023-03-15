package com.demo.appium.page.mobile;

import com.demo.appium.driver.DriverManager;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.HashSet;

public class HomeScreen extends AbstractScreenObject {

    @FindBy(id = "com.file.filemarket:id/swipeRefresh")
    private WebElement scrollView;

    @FindBy(id = "com.file.filemarket:id/rv_home_category")
    private WebElement categories;

    private final HashSet<WebElement> categoryList = new HashSet<>();

    @Step
    public boolean checkCategory(String name) {
        return categoryList.stream().anyMatch((c) -> c.getText().equals(name));
    }

    @Step
    public void getCategoryNames() {
        int listSize;

        while (true) {
            listSize = categoryList.size();
            categoryList.addAll(categories.findElements(By.className("android.widget.TextView")));

            if (listSize != categoryList.size())
                scrollDown(scrollView.getSize().height / 2);
            else
                break;
        }
    }

    public void scrollDown(int scrollSize) {
        var driver = DriverManager.getMobileDriver();
        Dimension windowSize = driver.manage().window().getSize();

        TouchAction action = new TouchAction((AndroidDriver) driver);
        action.press(PointOption.point(windowSize.width / 2, scrollView.getSize().height))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000)))
                .moveTo(PointOption.point(windowSize.width / 2, scrollView.getSize().height - scrollSize))
                .release()
                .perform();
    }

}