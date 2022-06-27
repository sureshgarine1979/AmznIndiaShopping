package com.amazon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SamsungProductDetailsPage extends Helper{
    WebDriver lDriver;

    public SamsungProductDetailsPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'About this item')]")
    private WebElement aboutThisItemHeader;

    @FindBy(xpath="//h1[contains(text(),'About this item')]/following-sibling::ul")
    private WebElement aboutThisSectionDetails;

    public void verifyAboutThisItemHeaderDisplayed(){
        String expectedText = getTextFromWebElement(lDriver,aboutThisItemHeader,10);
        Assert.assertEquals(expectedText,"About this item");
    }

    public void displayTextInAboutThisItemDetails(){
        String detailsText = getTextFromWebElement(lDriver,aboutThisSectionDetails,10);
        System.out.println(detailsText);
    }

}
