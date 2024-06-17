package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customelistener.CustomListeners;
import com.tutorialsninja.demo.pages.TopMenuPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {

    TopMenuPage topMenuPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        topMenuPage = new TopMenuPage();
    }

/*
    1.1 create method with name "selectMenu" it has one parameter name "menu" of type
string
1.2 This method should click on the menu whatever name is passed as parameter.
Write the following Test:
1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
1.1 Mouse hover on “Desktops” Tab and click
1.2 call selectMenu method and pass the menu = “Show All Desktops”
1.3 Verify the text ‘Desktops’
 */
    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        topMenuPage.mouseHoverToElementAndClickOnDesktop();
        topMenuPage.selectMenu("Show AllDesktops");
        Assert.assertEquals(topMenuPage.getTextDesktop(), "Desktops", "Message not displayed");
    }
/*
2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
2.1 Mouse hover on “Laptops & Notebooks” Tab and click
2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
2.3 Verify the text ‘Laptops & Notebooks’
 */
    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        topMenuPage.mouseHoverOnLaptopsAndNotebooksTab();
        topMenuPage.selectMenu("Show AllLaptops & Notebooks");
        Assert.assertEquals(topMenuPage.getLaptopsAndNotebooksText(), "Laptops & Notebooks", "Massage not displayed");
    }

    /*
    3. verifyUserShouldNavigateToComponentsPageSuccessfully()
3.1 Mouse hover on “Components” Tab and click
3.2 call selectMenu method and pass the menu = “Show All Components”
3.3 Verify the text ‘Components’
     */

    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        topMenuPage.mouseHoverToComponentsTab();
        topMenuPage.selectMenu("Show AllComponents");
        Assert.assertEquals(topMenuPage.getComponentsText(), "Components", "Message not displayed");

    }
}
