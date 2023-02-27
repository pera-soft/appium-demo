import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MainTest {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    final By googleSignInButton = By.xpath("//android.widget.ImageView[@content-desc=\"Google ile devam et\"]");
    final By account = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]");
    final By searchTextField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.EditText");
    final By result = By.xpath("//android.view.View[@content-desc=\"Üsküdar\nÜsküdar/İstanbul, Türkiye\"]");
    final By closeSearchButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]");
    final By optimizeRouteButton = By.xpath("//android.widget.Button[@content-desc=\"Rotayı Optimize Et\"]");
    final By locationPermission = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Poco");
        caps.setCapability("udid", "f85e0f40");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("appPackage", "software.pera.pera");
        caps.setCapability("appActivity", "software.pera.pera.MainActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void basicTest() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(googleSignInButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(account)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locationPermission)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextField)).click();

        Thread.sleep(2000);

        driver.findElement(searchTextField).click();
        driver.findElement(searchTextField).sendKeys("Üsküdar");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        wait.until(ExpectedConditions.visibilityOfElementLocated(result)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(closeSearchButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(optimizeRouteButton)).click();

        Thread.sleep(2000);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
