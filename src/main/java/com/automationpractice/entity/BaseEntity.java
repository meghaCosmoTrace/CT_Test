package com.automationpractice.entity;

import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.utility.DriverManager;
import org.openqa.selenium.WebDriver;

public abstract class BaseEntity {

    private WebDriver driver = DriverManager.getInstance().getDriver();

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage loginPageModule() {
        new HomePage().clickOnSignInLink();
        return new LoginPage();
    }

    public CreateAccountPage createAccountPageModule() {
        return new CreateAccountPage();
    }

    public MyAccountPage myAccountPageModule() {
        return new MyAccountPage();
    }
//    String pageHeading = myAccountPageModule.userNavigatedToMyAccount();
//			test.log(Status.INFO, "Account was created.");
//			myAccountPageModule.logOutOfApplication();
//			test.log(Status.INFO, "Logged out of Application");
}
