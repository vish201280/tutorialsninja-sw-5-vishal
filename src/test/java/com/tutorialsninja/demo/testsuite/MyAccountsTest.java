package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customelistener.CustomListeners;
import com.tutorialsninja.demo.pages.MyAccountsPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class MyAccountsTest extends BaseTest {

    MyAccountsPage myAccountsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        myAccountsPage = new MyAccountsPage();
    }

    /*
    1.1 create method with name "selectMyAccountOptions" it has one parameter name
"option" of type string
1.2 This method should click on the options whatever name is passed as parameter.
 (Hint: Handle List of Element and Select options)
Write the following test
1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
1.1 Click on My Account Link.
1.2 Call the method “selectMyAccountOptions” method and pass the parameter
 “Register”
1.3 Verify the text “Register Account”.
 */

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccountsPage.clickOnMyAccountLink();
        myAccountsPage.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccountsPage.getRegisterAccountMessage(), "Register Account", "Message not displayed");
    }
    /*
    2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
2.1 Clickr on My Account Link.
2.2 Call the method “selectMyAccountOptions” method and pass the parameter
 “Login”
2.3 Verify the text “Returning Customer”.
     */

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccountsPage.clickOnMyAccountLink();
        myAccountsPage.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccountsPage.getReturningCustomerMessage(), "Returning Customer", "Message not displayed");
    }
    /*
    3. Test name verifyThatUserRegisterAccountSuccessfully()
3.1 Clickr on My Account Link.
3.2 Call the method “selectMyAccountOptions” method and pass the parameter
 “Register”
3.3 Enter First Name
3.4 Enter Last Name
3.5 Enter Email
3.6 Enter Telephone
3.7 Enter Password
3.8 Enter Password Confirm
3.9 Select Subscribe Yes radio button
3.10 Click on Privacy Policy check box
 3.11 Click on Continue button
3.12 Verify the message “Your Account Has Been Created!”
3.13 Click on Continue button
 3.14 Clickr on My Account Link.
3.15 Call the method “selectMyAccountOptions” method and pass the parameter
 “Logout”
3.16 Verify the text “Account Logout”
3.17 Click on Continue button
     */

    @Test(groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully() {
        myAccountsPage.clickOnMyAccountLink();
        myAccountsPage.selectMyAccountOptions("Register");
        myAccountsPage.enterFirstName("Rudra");
        myAccountsPage.enterLastName("Patel");
        myAccountsPage.enterEmailId("rudra" + getAlphaNumericString(3) + "@gmail.com");
        myAccountsPage.enterPhoneNumber("1234567890");
        myAccountsPage.enterPassword("rudra123");
        myAccountsPage.enterConfirmPassword("rudra123");
        myAccountsPage.clickSubscribeOnYesRadioButton();
        myAccountsPage.clickOnPrivacyPolicyCheckBox();
        myAccountsPage.clickOnContinue1();
        Assert.assertEquals(myAccountsPage.getAccountCreatedMessage(), "Your Account Has Been Created!", "Message not displayed");
        myAccountsPage.clickOnContinueButton2();
        myAccountsPage.clickOnMyAccountTab();
        myAccountsPage.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountsPage.getAccountLogoutMessage(), "Account Logout", "Message not displayed");
        myAccountsPage.clickOnContinueButton3();

    }

    /*
    4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
4.1 Click on My Account Link.
4.2 Call the method “selectMyAccountOptions” method and pass the parameter
 “Login”
4.3 Enter Email address
4.4 Enter Last Name
4.5 Enter Password
4.6 Click on Login button
4.7 Verify text “My Account”
 4.8 Clickr on My Account Link.
4.9 Call the method “selectMyAccountOptions” method and pass the parameter
 “Logout”
4.10 Verify the text “Account Logout”
4.11 Click on Continue button
     */

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        myAccountsPage.clickOnMyAccountLink();
        myAccountsPage.selectMyAccountOptions("Login");
        myAccountsPage.enterEmailId("prime123" + getAlphaNumericString(0) + "@gmail.com");
        myAccountsPage.enterPassword("Prime123");
        myAccountsPage.clickOnLogin();
        // Assert.assertEquals(myAccountPage.getMyAccountText(),"My Account","My account text not displayed");
        myAccountsPage.clickOnMyAccountTab();
        myAccountsPage.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountsPage.getAccountLogoutMessage(), "Account Logout", "LogOut text not displayed");
        myAccountsPage.clickOnContinueButton3();
    }
}
