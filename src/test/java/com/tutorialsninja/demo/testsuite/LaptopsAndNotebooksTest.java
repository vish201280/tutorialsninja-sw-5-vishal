package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customelistener.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksTest extends BaseTest {

    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    DesktopsPage desktopPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        desktopPage = new DesktopsPage();
    }
    /*
     1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
1.1 Mouse hover on Laptops & Notebooks Tab.and click
1.2 Click on “Show All Laptops & Notebooks”
1.3 Select Sort By "Price (High > Low)"
1.4 Verify the Product price will arrange in High to Low order.
     */

    @Test(groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        laptopsAndNotebooksPage.mouseHoverOnLaptopsAndDesktopTab();
        laptopsAndNotebooksPage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.sortByPriceHighToLow();
        laptopsAndNotebooksPage.GetSortByHighToLowOrder();
    }
/*
2. Test name verifyThatUserPlaceOrderSuccessfully()
2.1 Mouse hover on Laptops & Notebooks Tab and click
2.2 Click on “Show All Laptops & Notebooks”
2.3 Select Sort By "Price (High > Low)"
2.4 Select Product “MacBook”
2.5 Verify the text “MacBook”
2.6 Click on ‘Add To Cart’ button
2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
2.8 Click on link “shopping cart” display into success message
2.9 Verify the text "Shopping Cart"
2.10 Verify the Product name "MacBook"
2.11 Change Quantity "2"
2.12 Click on “Update” Tab
2.13 Verify the message “Success: You have modified your shopping cart!”
2.14 Verify the Total £737.45
2.15 Click on “Checkout” button
2.16 Verify the text “Checkout”
2.17 Verify the Text “New Customer”
2.18 Click on “Guest Checkout” radio button
2.19 Click on “Continue” tab
2.20 Fill the mandatory fields
2.21 Click on “Continue” Button
2.22 Add Comments About your order into text area
2.23 Check the Terms & Conditions check box
2.24 Click on “Continue” button

     */

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        laptopsAndNotebooksPage.clickOnCurrencyLink();
        laptopsAndNotebooksPage.mouseHoverOnLaptopsAndDesktopTab();
        laptopsAndNotebooksPage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.sortByPriceHighToLow();
        laptopsAndNotebooksPage.clickOnSonyTab();
        laptopsAndNotebooksPage.clickOnAddToCartButton();
        String expectedText = "Success: You have added Sony VAIO to your shopping cart!\n" + "×";
        Assert.assertEquals(laptopsAndNotebooksPage.getSuccessTextFromLink(), expectedText, "Error Message not displayed");
        laptopsAndNotebooksPage.clickOnShoppingCart();
        Thread.sleep(3000);
        Assert.assertEquals(laptopsAndNotebooksPage.getShoppingCartMessage(), "Shopping Cart", "Message not displayed");
        Assert.assertEquals(laptopsAndNotebooksPage.getVerifyProductSonyVaio(), "Sony VAIO", "Message not displayed");
        Actions actions1 = new Actions(driver);
        WebElement quantity = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));
        quantity.clear();
        sendTextToElement(By.xpath("//input[contains(@name, 'quantity')]"), "2");
        laptopsAndNotebooksPage.clickOnUpdateCart();
        String expectedMessage = "Success: You have modified your shopping cart!\n" + "×";
        Assert.assertEquals(laptopsAndNotebooksPage.getSuccessModifiedCartMessage(), expectedMessage, "Message not displayed");
        Assert.assertEquals(laptopsAndNotebooksPage.getVerifyTotal(), "$2,404.00", "Price Not displayed");
        laptopsAndNotebooksPage.clickOnCheckoutButton();
        Assert.assertEquals(laptopsAndNotebooksPage.getCheckoutText(), "Checkout", "Message not displayed");
        Thread.sleep(2000);
        String expectedNewCustomer = "New Customer";
        Assert.assertEquals(laptopsAndNotebooksPage.getNewCustomerText(), expectedNewCustomer, "Message not displayed");
        laptopsAndNotebooksPage.clickOnGuestCheckoutRadioButton();
        laptopsAndNotebooksPage.clickOnContinueTab();
        laptopsAndNotebooksPage.enterName("Rudra");
        laptopsAndNotebooksPage.enterLastName("Patel");
        laptopsAndNotebooksPage.enterEmail("prime123" + getAlphaNumericString(3) + "@gmail.com");
        laptopsAndNotebooksPage.enterTelephone("1234567890");
        laptopsAndNotebooksPage.enterAddress("37 Southwell Drive");
        laptopsAndNotebooksPage.enterCity("Rugby");
        laptopsAndNotebooksPage.enterPostcode("CV23 1BY");
        laptopsAndNotebooksPage.enterCountry("United kingdom");
        laptopsAndNotebooksPage.enterZone("Angus");
        laptopsAndNotebooksPage.clickOnContinueButton();
        laptopsAndNotebooksPage.enterTextToTextArea("Please confirm delivery date");
        laptopsAndNotebooksPage.clickOnContinue1();
        laptopsAndNotebooksPage.clickOnTermsAndConditionsCheckbox();
        laptopsAndNotebooksPage.clickOnFinalContinueButton();

    }

}
