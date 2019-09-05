package webdriverImpl;

import org.openqa.selenium.WebDriver;

import java.util.Objects;
import java.util.Optional;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void startService();
    protected abstract void stopService();
    protected abstract void createDriver();

    public void quitDriver() {
        Optional.ofNullable(driver).ifPresent(d -> {
            d.quit();
            d = null;
        });
    }

    public WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            startService();
            createDriver();
        }
        return driver;
    }
}
