package tests;


import common.Session;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import webdriverImpl.ChromeDriverManager;
import webdriverImpl.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.ProjectProperties;
import utils.Properties;

import static java.util.concurrent.TimeUnit.SECONDS;

@ExtendWith(TestResultLoggerExtension.class)
public abstract class Settings {

    protected DriverManager driverManager;
    protected WebDriver driver;
    protected static String baseUrl;
    protected static int timeOut;

    static {
        ProjectProperties.load();
        baseUrl = Properties.getBaseUrl();
        timeOut = Properties.getPageLoadTimeOut();
    }

    @BeforeAll
    public static void loadProperties() {
        ProjectProperties.load();
        baseUrl = Properties.getBaseUrl();
        timeOut = Properties.getPageLoadTimeOut();
    }

    @BeforeEach
    public void setSettings() {
        driverManager = new ChromeDriverManager();
        driver = driverManager.getDriver();
        driver.manage().timeouts().pageLoadTimeout(timeOut, SECONDS);
    }

    @AfterEach
    public void close() {
        if (!Session.isTestResult())
            makeScreenShot();
        driverManager.quitDriver();
    }

    @Attachment(value = "{0}", type = "image/png")
    public synchronized byte[] makeScreenShot()
    {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
