package com.amazon.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class Helper {
    public void verifyTitleDisplayed(WebDriver driver, String pageTitle) {
        Assert.assertTrue(driver.getTitle().equals(pageTitle),"Web page title is incorrect");
    }

    public void clickOnWebElement(WebDriver driver, WebElement element, int timeOutInSec){
        try {
            WebDriverWait webWait = new WebDriverWait(driver, timeOutInSec);
            WebElement elements = null;
            elements = webWait.until(ExpectedConditions.elementToBeClickable(element));
            elements.click();
        } catch (Exception e) {
            System.out.println("Element is not clickable "+e);
        }

    }

    public void scrollToWebElement(WebDriver driver, WebElement element, int timeOutInSec){
        try {
            WebDriverWait webWait = new WebDriverWait(driver, timeOutInSec);
            WebElement elements = null;
            elements = webWait.until(ExpectedConditions.visibilityOf(element));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements);

        } catch (Exception e) {
            System.out.println("Element is not scrolled the the desired locator "+e);
        }

    }

    public void switchToWindow(WebDriver driver, String windowID){
        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            if(window!=windowID){
                driver.switchTo().window(window);
            }
        }
    }

    public String getTextFromWebElement(WebDriver driver,WebElement element,int timeOutInSec){
        WebElement elements = null;
        try {
            WebDriverWait webWait = new WebDriverWait(driver, timeOutInSec);
            elements = webWait.until(ExpectedConditions.visibilityOf(element));

        } catch (Exception e) {
            System.out.println("Unable to read Text from WebElement"+e.getMessage());
        }
        return elements.getText();
    }
}
