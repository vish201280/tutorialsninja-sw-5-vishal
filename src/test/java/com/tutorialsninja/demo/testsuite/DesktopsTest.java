package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customelistener.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {


    DesktopsPage desktopsPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        desktopsPage = new DesktopsPage();
        softAssert = new SoftAssert();
    }
/*
 Write the following Test:
1.Test name verifyProductArrangeInAlphaBaticalOrder()
1.1 Mouse hover on Desktops Tab. and click
1.2 Click on “Show All Desktops”
1.3 Select Sort By position "Name: Z to A"
1.4 Verify the Product will arrange in Descending order.
 */
    @Test(groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        desktopsPage.clickOnCurrencyLink();
        desktopsPage.mouseHoverOnDesktop();
        desktopsPage.clickOnShowAllDesktop();
        desktopsPage.sortByPositionNameZtoA("Name (Z - A)");
        desktopsPage.getProductsArrangeInDescendingOrderText();
    }

    /*
   2. Test name verifyProductAddedToShoppingCartSuccessFully(String product, String qty,
   String successMessage, String productName, String model, String total )
   2.1 Mouse hover on Currency Dropdown and click
    2.2 Mouse hover on £Pound Sterling and click
    2.3 Mouse hover on Desktops Tab.
   2.4 Click on “Show All Desktops”
   2.5 Select Sort By position "Name: A to Z"
   2.6 Select product <product>
   2.7 Enter Qty <qty> using Select class.
   2.8 Click on “Add to Cart” button
   2.9 Verify the Message <successMessage>
    2.10 Click on link “shopping cart” display into success message
   2.11 Verify the text "Shopping Cart"
   2.12 Verify the Product name <productName>
   2.13 Verify the Model <model>
   2.14 Verify the Total <total>
   DATA SET
   | product | qty | successMessage | productName | model | total |
   | HTC Touch HD | 1 | Success: You have added HTC Touch HD to your shopping cart! | HTC Touch HD | Product 1 | £74.73 |
   | iPhone | 2 | Success: You have added iPhone to your shopping cart! | iPhone | product 11 | £150.92 |
   | Palm Treo Pro | 3 | Success: You have added Palm Treo Pro to your shopping cart! | Palm Treo Pro | Product 2 | £1,242.11 |
        */

    @Test(groups = {"smoke", "regression"}, dataProvider = "desktopsData", dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty, String successMessage, String productName, String model, String total) throws InterruptedException {
        desktopsPage.clickOnCurrencyLink();
        desktopsPage.mouseHoverOnDesktop();
        desktopsPage.clickOnShowAllDesktop();
        desktopsPage.sortByPositionNameAtoZ("Name (A - Z)");
        desktopsPage.clickOnProduct(product);
        desktopsPage.clearTextFromTag(desktopsPage.clearText);
        desktopsPage.sendTextToElement(desktopsPage.clearText,qty);
        desktopsPage.clickOnAdToCart();
        String expString = desktopsPage.getSuccessAlertMsg();
        String expString2 = expString.split("!")[0];
        softAssert.assertEquals(expString, "Success: You have added " + product + " to your shopping cart!\n"+"×");
        desktopsPage.clickOnShoppingCart();
        Thread.sleep(2000);
        softAssert.assertEquals(desktopsPage.getProductName(),product,"product name not matched");
        softAssert.assertEquals(desktopsPage.getModel(),model,"Model not matched");
        softAssert.assertEquals(desktopsPage.getTotal(),total,"Total not matched");


    }


}
