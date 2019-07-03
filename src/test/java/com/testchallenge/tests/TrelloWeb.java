package com.testchallenge.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.testchallenge.tests.BaseTest.*;

@Test
public class TrelloWeb {
    public String baseUrl = "https://trello.com/";
    String driverPath = "~/geckodriver";
    public WebDriver driver;
    public String expected = null;
    public String actual = null;
    @BeforeClass
    public void launchBrowser() {
        System.out.println("launching firefox browser");
        System.setProperty("webdriver.firefox.marionette", driverPath);
        driver= new FirefoxDriver();
        driver.get(baseUrl);
    }


    @Test
    public void register() throws Exception {
        WelcomePage.clickWebSignInButton();
        WelcomePage.clickWebUserAndPassInButton();
        SignInPage.enterWebTextInUser();
        SignInPage.enterWebTextInPassword();
        SignInPage.clickWebSignInButton();
        HomePage.checkWebHomePageDisplayed();
        HomePage.clickCard();
        HomePage.dragAndDropCard();
    }


    @AfterClass
    public void terminateBrowser(){
        driver.close();
    }
}
