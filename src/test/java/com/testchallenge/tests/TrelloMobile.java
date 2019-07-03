package com.testchallenge.tests;

import com.testchallenge.Labels;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class TrelloMobile extends BaseTest {

    @BeforeClass
    public static void setUp() throws Exception {//need  to implement switch
        capabilities = new DesiredCapabilities().android();
        capabilities.setCapability("BROWSER_NAME", Labels.ANDROID_CAPABILITIES_BROWSER_NAME);
        capabilities.setCapability("VERSION", Labels.ANDROID_CAPABILITIES_PLATFORM_VERSION);
        capabilities.setCapability("deviceName", Labels.ANDROID_CAPABILITIES_DEVICE_NAME);
        capabilities.setCapability("platformName", Labels.ANDROID_CAPABILITIES_BROWSER_NAME);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("appPackage", Labels.ANDROID_CAPABILITIES_PACKAGE_NAME);
        capabilities.setCapability("appActivity", Labels.APP_ACTIVITY);
        capabilities.setCapability("autoAcceptAlerts", true);
//        File app = new File(Labels.ANDROID_CAPABILITIES_APP_PATH);
//        String appPAthPathCapability = app.getAbsolutePath();
//        capabilities.setCapability("app", appPAthPathCapability);

        capabilities.setCapability("newCommandTimeout", "7200");
        driver = new AndroidDriver<WebElement>(new URL(Labels.ANDROID_CAPABILITIES_URL), capabilities);
        System.out.println("Session ID : " + driver.getSessionId());
        driverWait = new WebDriverWait(driver, Labels.DEFAULT_WAITING_TIME);
        System.out.println("Session ID : " + driver.getSessionId());
    }

    @AfterClass
    public static void tearDown() throws Exception {
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
