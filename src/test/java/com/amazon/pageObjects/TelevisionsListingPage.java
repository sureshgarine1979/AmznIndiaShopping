package com.amazon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TelevisionsListingPage extends Helper {
    WebDriver lDriver;
    public TelevisionsListingPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver,this);
    }

    @FindBy(xpath="//*[@id='s-refinements']/div[20]/div/span")
    private WebElement brandsFilter;

    @FindBy(xpath="//*[@id='s-refinements']//span[contains(text(),'Samsung')]/..")
    private WebElement samsungCheckBox;

    public void scrollDownToBrandsFilter() {
        scrollToWebElement(lDriver,brandsFilter,10);
    }

    public SamsungResultsListingPage clickSamsungCheckBox() {
        clickOnWebElement(lDriver,samsungCheckBox,10);
        return new SamsungResultsListingPage(lDriver);
    }
}
