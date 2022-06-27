package com.amazon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Helper {
    WebDriver lDriver;
    public static String baseURL = "http://www.amazon.in";
    public HomePage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver,this);
    }

    @FindBy(id="nav-hamburger-menu")
    private WebElement hamburgerMenu;

    @FindBy(xpath="//div[contains(text(),'shop by department')]")
    private WebElement shopByDept;

    @FindBy(xpath = "//div[contains(text(),'TV, Appliances, Electronics')]/following-sibling::i")
    private WebElement tvAppliancesElectronicsLink;

    @FindBy(xpath = "//a[contains(text(),'Televisions')]")
    private WebElement televisionSubMenuLink;


    public void navigateToHomePage(){
        lDriver.get(baseURL);
    }

    public void verifyPageTitleDisplayed(WebDriver lDriver, String pageTitle){
        verifyTitleDisplayed(lDriver,pageTitle);
    }

    public void clickOnHamburgerMenu(){
        clickOnWebElement(lDriver,hamburgerMenu,20);
    }
    public void scrollToShopByDept() {
        scrollToWebElement(lDriver,shopByDept,10);
    }

    public void clickTvAppliancesElectronicsLink(){
        clickOnWebElement(lDriver,tvAppliancesElectronicsLink,10);
    }

    public TelevisionsListingPage clickTelevisionsSubMenuLink() {
        clickOnWebElement(lDriver,televisionSubMenuLink,10);
        return new TelevisionsListingPage(lDriver);
    }
}
