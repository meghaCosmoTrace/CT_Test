package com.automationpractice.runner;

import com.automation.remarks.testng.UniversalVideoListener;
import com.automationpractice.data.CreateAccountData;
import com.automationpractice.data.LoginPageData;
import com.automationpractice.data.MyAccountData;
import com.automationpractice.entity.CreateAccountEntity;
import com.automationpractice.entity.LoginPageEntity;
import com.automationpractice.entity.MyAccountEntity;
import com.automationpractice.listener.Listener;
import com.automationpractice.utility.DateUtility;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Listener.class, UniversalVideoListener.class})
@Epic("My Store Epic")
@Feature("To test the functionality of My Store application")
public class AutomationPracticeTest extends BaseTest {

    @Test()
    @Description("Test to verify the creation of new account")
    public void TC001_CreateNewAccount() {
        //Login Page
        LoginPageData loginPageData = new LoginPageData();
        String email = String.format("test%s@gmail.com", DateUtility.getStringDate("DDhhmmss"));
        loginPageData.setCreateAccountEmail(email);
        loginPageData.setCreateAccountButton(true);
        loginPageData.setLoginButtonText("Sign in");

        LoginPageEntity loginPageEntity = new LoginPageEntity(loginPageData);
        loginPageEntity.verify();
        loginPageEntity.create();

        //create account
        CreateAccountData data = new CreateAccountData(); //Data Class
        data.setFirstName(testDataMapValue("firstNameColumn"));
        data.setLastName(testDataMapValue("lastNameColumn"));
        data.setPassword(testDataMapValue("passwordColumn"));
        data.setRegisterButton(true);

        CreateAccountEntity entity = new CreateAccountEntity(data); //Entity Class
        entity.create();

        //navigate to my account
        MyAccountData myAccountData = new MyAccountData();
        myAccountData.setPageHeading("My account");

        MyAccountEntity myAccountEntity = new MyAccountEntity(myAccountData);
        myAccountEntity.verify();

        //search an item
        myAccountData = new MyAccountData();
        myAccountEntity = new MyAccountEntity(myAccountData);
        myAccountData.setSearchQuery("Printed Dress");
        myAccountData.setSubmitSearch(true);
        myAccountEntity.create();

        //sign out
        myAccountData = new MyAccountData();
        myAccountEntity = new MyAccountEntity(myAccountData);
        myAccountData.setSignOut(true);
        myAccountEntity.create();

    }

//    @Video
//    @Test (groups = { "regression","smoke"})
//    @Severity (SeverityLevel.NORMAL)
//    @Description ("Test to verify the purchase the Printed Summary Dress")
//    @Story ("Purchase Dress")
//    public void TC002_PurchasePrintedSummaryDress() {
//        String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
//        ProductCheckoutScript productCheckoutScript = new ProductCheckoutScript(DriverManager.getInstance().getDriver());
//        productCheckoutScript.checkOutProduct(testCaseName);
//    }
//
//    @Video
//    @Test (groups = { "regression"})
//    @Severity (SeverityLevel.NORMAL)
//    @Description ("Test to verify the purchase the Printed Chiffon Dress")
//    @Story ("Purchase Dress")
//    public void TC003_PurchasePrintedChiffonDress() {
//        String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
//        ProductCheckoutScript productCheckoutScript = new ProductCheckoutScript(DriverManager.getInstance().getDriver());
//        productCheckoutScript.checkOutProduct(testCaseName);
//    }
//
//    @Video
//    @Test
//    @Severity (SeverityLevel.NORMAL)
//    @Description ("Test to verify the login functionality with invalid credentials")
//    @Story ("Login to Application")
//    public void TC004_InvalidLogin() {
//        String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
//        LoginScript loginScript = new LoginScript(DriverManager.getInstance().getDriver());
//        loginScript.loginTest(testCaseName);
//    }
}
