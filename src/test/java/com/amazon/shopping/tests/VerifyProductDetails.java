package com.amazon.shopping.tests;

import com.amazon.pageObjects.HomePage;
import com.amazon.pageObjects.SamsungProductDetailsPage;
import com.amazon.pageObjects.SamsungResultsListingPage;
import com.amazon.pageObjects.TelevisionsListingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyProductDetails extends BaseClass {
    public static Logger logger = LogManager.getLogger(VerifyProductDetails.class);

    @Parameters("browser")
    @Test
    public void verifyProductDetails() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        homePage.verifyPageTitleDisplayed(driver,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
        logger.info("Amazon.in URL is opened");
        homePage.clickOnHamburgerMenu();
        logger.info("clicked on Hamburger menu");
        homePage.scrollToShopByDept();
        logger.info("scrolled to Shop by department");
        homePage.clickTvAppliancesElectronicsLink();
        logger.info("clicked on Tv, appliances, electronics link");
        TelevisionsListingPage televisionsListingPage = homePage.clickTelevisionsSubMenuLink();
        logger.info("clicked on Televisions sub menu item");
        televisionsListingPage.scrollDownToBrandsFilter();
        logger.info("scroll down to Brands filter");
        SamsungResultsListingPage samsungResultsListingPage = televisionsListingPage.clickSamsungCheckBox();
        logger.info("Samsung filtered Product listing page displayed");
        samsungResultsListingPage.clickSortByDropDown();
        logger.info("Clicked on Sort by dropdown");
        samsungResultsListingPage.clickHighToLowPriceSelection();
        logger.info("Selected price High to low value selected from dropdown");
        SamsungProductDetailsPage samsungProductDetailsPage = samsungResultsListingPage.clickSecondItemInTheProductListing();
        logger.info("Clicked on Second item in the product listings page");
        samsungProductDetailsPage.verifyAboutThisItemHeaderDisplayed();
        logger.info("About this section header displayed in product details page");
        samsungProductDetailsPage.displayTextInAboutThisItemDetails();
        logger.info("About this item section details displayed");

    }
}
