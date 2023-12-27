package com.automationpractice.elements;

import com.automationpractice.utility.AssertUtility;
import com.automationpractice.utility.DriverManager;
import com.automationpractice.utility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BaseElements {
    public WebElement element;
    private WebDriver driver;

    public BaseElements(By locator) {
        // Assuming driver is initialized elsewhere before creating BaseElements instances
        this.driver = DriverManager.getInstance().getDriver();
        this.element = driver.findElement(locator);
    }

    public BaseElements click() {
        element.click();
        return this;
    }

    public BaseElements sendKeys(String text) {
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public String getText() {
        return element.getText();
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    // Add more common functions as needed

    public BaseElements selectDropdownOption(String option) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(option);
        return this;
    }

    public void set(String text) {
        if (text != null)
            sendKeys(text);
    }

    public void set(Boolean action) {
        if (action != null)
            if (action)
                click();
    }

    public void verify(String text) {
        verify(text, getText());
    }

    public void verify(String text, String label) {
        Log.info("Assert value of: " + label + " " + getText() + " equals " + text);
        AssertUtility.assertEquals(getText(), text, label);
    }

    public void verifyContains(String text, String label) {
        Log.info("Assert value of: " + getText() + "equals" + text);
        AssertUtility.assertContains(getText(), text, label);
    }
}
