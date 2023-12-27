package com.automationpractice.pages;

import com.automationpractice.data.BaseData;
import com.automationpractice.utility.ConfigReader;
import com.automationpractice.utility.DriverManager;
import com.automationpractice.utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class BasePage {

    protected WebDriver driver;
    protected String pageTitle;

    public BasePage() {
        this.driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,
                Integer.parseInt(ConfigReader.getProperty("webDriverWaitTime"))), this);
        logPageTitle();
    }

    private void logPageTitle() {
        pageTitle = driver.getTitle();
        Log.info("Navigated to " + pageTitle + " page.");
    }

    abstract void fillout(BaseData bData);

    abstract void verify(BaseData bData);
}
