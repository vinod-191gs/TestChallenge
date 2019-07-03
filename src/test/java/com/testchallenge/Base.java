package com.testchallenge;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.URL;

public class Base {
    public static DesiredCapabilities capabilities;
    public static AppiumDriver<WebElement> driver;
    public static WebDriver webDriver;

    public static WebDriverWait driverWait;



    /**
     * Verify sub element is displayed in screen using element id as parameter.
     *
     * @param elementId element id.
     * @return status returns true if element displayed else false.
     * @throws Exception
     */
    public static boolean isElementDisplayedById(String elementId) throws Exception {
        int counter = 0;

        while (counter < Labels.MIN_ATTEMPTS) {
            try {
                boolean status = driver.findElementById(elementId).isDisplayed();
                if (status) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println(counter + " time trying to find " + elementId);
            }
            Thread.sleep(Labels.WAIT_TIME_DEFAULT);
            counter++;
        }
        return false;
    }

    /**
     * Verify sub element is displayed in screen using element id as parameter.
     *
     * @param elementId element id.
     * @return status returns true if element displayed else false.
     * @throws Exception
     */
    public static boolean isWebElementDisplayedById(String elementId) throws Exception {
        int counter = 0;

        while (counter < Labels.MIN_ATTEMPTS) {
            try {
                boolean status = webDriver.findElement(By.id(elementId)).isDisplayed();
                if (status) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println(counter + " time trying to find " + elementId);
            }
            Thread.sleep(Labels.WAIT_TIME_DEFAULT);
            counter++;
        }
        return false;
    }

    /**
     * Verify sub element is displayed in screen using element id as parameter.
     *
     * @param elementId element id.
     * @return status returns true if element displayed else false.
     * @throws Exception
     */
    public static boolean isWebElementDisplayedByClassName(String elementId) throws Exception {
        int counter = 0;

        while (counter < Labels.MIN_ATTEMPTS) {
            try {
                boolean status = webDriver.findElement(By.className(elementId)).isDisplayed();
                if (status) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println(counter + " time trying to find " + elementId);
            }
            Thread.sleep(Labels.WAIT_TIME_DEFAULT);
            counter++;
        }
        return false;
    }

    /**
     * Tap on element using element Id as parameter.
     *
     * @param elementId element class name.
     * @return status returns true if element is tapped else false.
     * @throws Exception
     */
    public static boolean findWebElementByClassNameAndClick(String elementId) throws Exception {
        int counter = 0;
        while (counter < Labels.MIN_ATTEMPTS) {
            try {
                WebElement element = webDriver.findElement(By.className(elementId));
                if (element.isDisplayed()) {
                    element.click();
                    return true;
                }
            } catch (Exception e) {
                System.out.println(counter + " time trying to find " + elementId);
            }
            counter++;
        }
        return false;
    }

    /**
     * Tap on element using element Id as parameter.
     *
     * @param elementId element class name.
     * @return status returns true if element is tapped else false.
     * @throws Exception
     */
    public static boolean findWebElementByIdAndClick(String elementId) throws Exception {
        int counter = 0;
        while (counter < Labels.MIN_ATTEMPTS) {
            try {
                WebElement element = webDriver.findElement(By.id(elementId));
                if (element.isDisplayed()) {
                    element.click();
                    return true;
                }
            } catch (Exception e) {
                System.out.println(counter + " time trying to find " + elementId);
            }
            counter++;
        }
        return false;
    }

    /**
     * Tap on element using element Id as parameter.
     *
     * @param elementId element class name.
     * @return status returns true if element is tapped else false.
     * @throws Exception
     */
    public static boolean findElementByIdAndClick(String elementId) throws Exception {
        int counter = 0;
        while (counter < Labels.MIN_ATTEMPTS) {
            try {
                WebElement element = driver.findElementById(elementId);
                if (element.isDisplayed()) {
                    element.click();
                    return true;
                }
            } catch (Exception e) {
                System.out.println(counter + " time trying to find " + elementId);
            }
            counter++;
        }
        return false;
    }


    public void enterTextInToField(String toFieldText, String elementId) throws Exception {
        try{
            Assert.assertTrue("Email field To should be displayed.", isElementDisplayedById(elementId));
            AndroidElement toField= (AndroidElement) driver.findElement(By.id(elementId));
            toField.clear();
            toField.sendKeys(toFieldText);
            driver.hideKeyboard();
        }catch (NoSuchElementException exception){
            System.out.println(exception);
        }
    }

    public static boolean findElementByNameAndClick(String elementName) throws Exception {
        int counter = 0;

        while (counter < Labels.MIN_ATTEMPTS) {
            try {
                WebElement element = driver.findElementByName(elementName);
                if (element.isDisplayed()) {
                    element.click();
                    return true;
                }
            } catch (Exception e) {
                System.out.println(counter + " time trying to find " + elementName);
            }
            counter++;
            Thread.sleep(Labels.WAIT_TIME_MIN);
        }
        return false;
    }

    public static boolean findWebElementByNameAndClick(String elementName) throws Exception {
        int counter = 0;

        while (counter < Labels.MIN_ATTEMPTS) {
            try {
                WebElement element = webDriver.findElement(By.name(elementName));
                if (element.isDisplayed()) {
                    element.click();
                    return true;
                }
            } catch (Exception e) {
                System.out.println(counter + " time trying to find " + elementName);
            }
            counter++;
            Thread.sleep(Labels.WAIT_TIME_MIN);
        }
        return false;
    }
}
