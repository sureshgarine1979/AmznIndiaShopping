package com.amazon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamsungResultsListingPage extends Helper{
    WebDriver lDriver;

    public SamsungResultsListingPage(WebDriver rDriver) {
         lDriver = rDriver;
        PageFactory.initElements(rDriver,this);
    }

    @FindBy(xpath = "//span[@id='a-autoid-0-announce']/span[2]")
    private WebElement featuredDropDown;

    @FindBy(id="s-result-sort-select_2")
    private WebElement priceHighToLow;

    @FindBy(xpath="//span[contains(text(),'RESULTS')]/ancestor::div[5]/div[3]")
    private WebElement secondResult;


    public  void clickSortByDropDown() {
        clickOnWebElement(lDriver,featuredDropDown,10);
    }

    public  void clickHighToLowPriceSelection() {
        clickOnWebElement(lDriver,priceHighToLow,10);
    }

    public SamsungProductDetailsPage clickSecondItemInTheProductListing() {
        clickOnWebElement(lDriver,secondResult,10);
        String windowHandle = lDriver.getWindowHandle();
        switchToWindow(lDriver,windowHandle);
        return new SamsungProductDetailsPage(lDriver);
    }

}
