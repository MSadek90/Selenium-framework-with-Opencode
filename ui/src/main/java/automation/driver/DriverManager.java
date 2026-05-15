package automation.driver;

import automation.config.ConfigManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public final class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void initDriver() {
        String browserName = ConfigManager.config().browser();
        BrowserType browserType = BrowserType.valueOf(browserName.toUpperCase());
        WebDriver driver = DriverFactory.createDriver(browserType);
        driver.manage().window().maximize();
        driverThreadLocal.set(driver);
        log.info("Browser started: {}", browserName);
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
            log.info("Browser stopped");
        }
    }
}
