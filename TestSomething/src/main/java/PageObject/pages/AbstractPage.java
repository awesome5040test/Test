package PageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class AbstractPage {
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
