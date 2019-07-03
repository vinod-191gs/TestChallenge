package com.testchallenge.pages.welcome;

import com.testchallenge.Labels;
import com.testchallenge.pages.BasePage;
import com.testchallenge.pages.interfaces.WelcomeInterface;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;

public class Welcome extends BasePage implements WelcomeInterface {

    @Override
    public void clickSignInButton() throws Exception {
        Assert.assertTrue("Login button should be displayed.", isElementDisplayedById(Labels.WELCOME_LOGIN_BUTTON));
        Assert.assertTrue("Failed to click on sign in button.", findElementByIdAndClick(Labels.WELCOME_LOGIN_BUTTON));

    }

    @Override
    public void clickWebSignInButton() throws Exception {
        Assert.assertTrue("Login button should be displayed.", isWebElementDisplayedByClassName(Labels.WEB_WELCOME_LOGIN_BUTTON));
        Assert.assertTrue("Failed to click on sign in button.", findWebElementByClassNameAndClick(Labels.WEB_WELCOME_LOGIN_BUTTON));

    }

    @Override
    public void clickWebUserAndPassInButton() throws Exception {
        Assert.assertTrue("Login button should be displayed.", isWebElementDisplayedById(Labels.WEB_WELCOME_USE_PASSWORD_BUTTON));
        Assert.assertTrue("Failed to click on sign in button.", findWebElementByClassNameAndClick(Labels.WEB_WELCOME_USE_PASSWORD_BUTTON));

    }

}
