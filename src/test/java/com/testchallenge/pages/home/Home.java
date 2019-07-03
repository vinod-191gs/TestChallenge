package com.testchallenge.pages.home;

import com.testchallenge.Labels;
import com.testchallenge.pages.BasePage;
import com.testchallenge.pages.interfaces.HomeInterface;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Home extends BasePage implements HomeInterface {

    @Override
    public void checkHomePageDisplayed() throws Exception {
        Assert.assertTrue("Home page should be displayed.", isElementDisplayedById(Labels.HOME_PAGE));

    }
    @Override
    public void addLabelToCard() throws Exception {
        Assert.assertTrue("Failed to click on card name.", findElementByNameAndClick(Labels.CARD_NAME));
        Assert.assertTrue("Failed to click on label icon.", findElementByIdAndClick(Labels.EDIT_LABEL_NAME));
        Assert.assertTrue("Failed to click on label.", findElementByIdAndClick(Labels.LABEL_NAME));
    }

    @Override
    public void checkWebHomePageDisplayed() throws Exception {
        Assert.assertTrue("Home page should be displayed.", isWebElementDisplayedByClassName(Labels.WEB_HOME_PAGE));

    }
    @Override
    public void clickCard() throws Exception {
        Assert.assertTrue("Failed to click on card name.", findElementByNameAndClick(Labels.CARD_NAME));
    }

    @Override
    public void dragAndDropCard() throws Exception {
        Actions action = new Actions(driver);
        WebElement sourceLocator = driver.findElement(By.className("list-card-details js-card-details"));
        WebElement targetLocator = driver.findElement(By.className("list-header-target js-editing-target"));
        action.dragAndDrop(sourceLocator, targetLocator).build().perform();
    }

}
