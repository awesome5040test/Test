package tests;


import common.BROWSERS;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ProjectProperties;
import utils.Properties;

import static java.util.concurrent.TimeUnit.SECONDS;


public abstract class Settings {

    protected static WebDriver driver = null;
    protected static String browser;
    protected static String baseUrl;
    protected static int timeOut;

    static {
        ProjectProperties.load();
        browser = Properties.getBrowser();
        baseUrl = Properties.getBaseUrl();
        timeOut = Properties.getPageLoadTimeOut();
    }

    @BeforeEach
    public void setSettings(){
        this.driver = setDriver();
}

    protected WebDriver setDriver(){
        if (browser.equals(BROWSERS.CHROME.getName()))
                    driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(timeOut, SECONDS);
        return driver;
    };

    @AfterEach
    public void close(){
        this.driver.quit();
    }


}
