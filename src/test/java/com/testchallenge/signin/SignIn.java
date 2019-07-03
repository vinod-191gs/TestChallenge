package com.testchallenge.signin;

import com.testchallenge.Labels;
import com.testchallenge.pages.BasePage;
import com.testchallenge.pages.interfaces.SignInInterface;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;

public class SignIn extends BasePage implements SignInInterface {

    @Override
    public void clickSignInButton() throws Exception {
        Assert.assertTrue("Login button should be displayed.", isElementDisplayedById(Labels.SIGNIN_LOGIN_BUTTON));
        Assert.assertTrue("Failed to click on sign in button.", findElementByIdAndClick(Labels.SIGNIN_LOGIN_BUTTON));

        }

    @Override
    public void enterTextInUser() throws Exception {
        Assert.assertTrue("user text field should be displayed.", isElementDisplayedById(Labels.SIGNIN_USER));
        enterTextInToField("vgstest77@gmail.com", Labels.SIGNIN_USER);

    }
    @Override
    public void enterTextInPassword() throws Exception {
        Assert.assertTrue("user text field should be displayed.", isElementDisplayedById(Labels.SIGNIN_PASSWORD));
        enterTextInToField("Vinod@123", Labels.SIGNIN_PASSWORD);

    }@Override
    public void clickWebSignInButton() throws Exception {
        Assert.assertTrue("Login button should be displayed.", isWebElementDisplayedById(Labels.SIGNIN_WEB_LOGIN_BUTTON));
        Assert.assertTrue("Failed to click on sign in button.", findElementByIdAndClick(Labels.SIGNIN_WEB_LOGIN_BUTTON));

        }

    @Override
    public void enterWebTextInUser() throws Exception {
        Assert.assertTrue("user text field should be displayed.", isWebElementDisplayedById(Labels.SIGNIN_WEB_USER));
        WebElement userText = (WebElement) driver.findElementsById(Labels.SIGNIN_WEB_USER);
        userText.sendKeys("vgstest77@gmail.com");

    }
    @Override
    public void enterWebTextInPassword() throws Exception {
        Assert.assertTrue("user text field should be displayed.", isWebElementDisplayedById(Labels.SIGNIN_WEB_PASSWORD));
        WebElement password = (WebElement) driver.findElementsById(Labels.SIGNIN_WEB_PASSWORD);
        password.sendKeys("Vinod@123");

    }
}
