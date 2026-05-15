package automation.driver;

import static automation.util.AllureLogger.step;

import automation.config.ConfigManager;
import org.openqa.selenium.WebDriver;

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
        step("Browser started: {}", browserName);
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
            step("Browser stopped");
        }
    }
}
