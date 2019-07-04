package com.testchallenge.tests;

import com.testchallenge.Labels;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class TrelloMobile extends BaseTest {
    public AppiumDriver<WebElement> driver;

    @BeforeClass
    public void setUp() throws Exception {//need  to implement switch
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", Labels.ANDROID_CAPABILITIES_PLATFORM_VERSION);
        capabilities.setCapability("deviceName", Labels.ANDROID_CAPABILITIES_DEVICE_NAME);
        capabilities.setCapability("platformName", Labels.ANDROID_CAPABILITIES_BROWSER_NAME);
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("appPackage", "com.trello");
        capabilities.setCapability("appActivity", "com.trello.home.HomeActivity");
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("newCommandTimeout", "7200");
        driver = (AppiumDriver<WebElement>) new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testStatsViewDisplaysTheCorrectCategoriesForEachColumn() throws Exception{

        WelcomePage.clickSignInButton();
        SignInPage.enterTextInUser();
        SignInPage.enterTextInPassword();
        SignInPage.clickSignInButton();
        HomePage.checkHomePageDisplayed();
        HomePage.addLabelToCard();

    }
}
