package com.automationpractice.runner;

import com.automationpractice.listener.WebDriverListener;
import com.automationpractice.utility.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.automationpractice.utility.ResourceUtility.getExecFolderPath;

public class BaseTest {

    private static Map testDataMap;
    private final String excelSheetPath = ResourceUtility.getDataFolderPath();

    // Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    // HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @BeforeSuite
    public void configuringLog4j() throws IOException {
        AllureConfigurator.configure();
    }

    @BeforeMethod
    public void browserSetup(Method m) {
        //initializing testDataMap object to read values from the Excel file
        String testCaseName = m.getName();

        testDataMap = new ExcelUtility().getData(testCaseName, excelSheetPath,
                ConfigReader.getProperty("testDataSheetName"));

        launchBrowser(ConfigReader.getProperty("appUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void browserTeardown(ITestResult result) throws Exception {
        WebDriver driver = DriverManager.getInstance().getDriver();
        String testCaseName = result.getMethod().getConstructorOrMethod().getName();
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                saveTextLog(testCaseName + " Failed, Please find the attached screenshot");
                saveScreenshot(driver);
                String imageFilePath = ScreenshotUtility.takeFullScreenShot(driver, testCaseName + "_Failed");
                ReportManager.getTest().error("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(imageFilePath).build());
            } catch (IOException e) {
                e.printStackTrace();
                Log.error("Error occured while attaching screenshot: " + e.getMessage());
            }
        }
        DriverManager.getInstance().getEventFiringWebDriver().unregister(DriverManager.getInstance().getWebDriverListener());
        closeBrowser(driver);
    }

    public WebDriver launchBrowser(String url) {
        System.out.println("Launching Browser.");
        System.setProperty("webdriver.chrome.driver", getExecFolderPath() + "/chromedriver_mac_120");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-infobars");
        option.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(option);
        EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
        WebDriverListener listener = new WebDriverListener();
        eventHandler.register(listener);
        driver = eventHandler;
        DriverManager.getInstance().setWebDriverListener(listener);
        DriverManager.getInstance().setEventFiringWebDriver(eventHandler);
        DriverManager.getInstance().setDriver(driver);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitlyWaitTime")), TimeUnit.SECONDS);
        return driver;
    }

    public void closeBrowser(WebDriver driver) throws Exception {
        System.out.println("Closing Browser.");
        driver.quit();
    }

    protected String testDataMapValue(String field) {
        return (String) testDataMap.get(ConfigReader.getProperty(field));
    }

    // Image attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Video attachments for Allure
    @Attachment(value = "video", type = "video/webm")
    public byte[] attachVideo(String path) throws Exception {
        return Files.readAllBytes(Paths.get(new File(path).getAbsolutePath()));
    }
}
