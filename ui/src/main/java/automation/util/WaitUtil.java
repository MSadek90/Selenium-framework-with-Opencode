package automation.util;

import automation.config.ConfigManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class WaitUtil {

    private final WebDriverWait wait;

    public WaitUtil(WebDriver driver) {
        long timeout = ConfigManager.config().explicitWait();
        log.debug("Initializing WebDriverWait with timeout: {}s", timeout);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public WebElement waitForVisible(By locator) {
        log.debug("Waiting for element to be visible: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForVisible(WebElement element) {
        log.debug("Waiting for element to be visible");
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(By locator) {
        log.debug("Waiting for element to be clickable: {}", locator);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForClickable(WebElement element) {
        log.debug("Waiting for element to be clickable");
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForPresence(By locator) {
        log.debug("Waiting for element presence: {}", locator);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public <T> T until(ExpectedCondition<T> condition) {
        log.debug("Waiting for custom condition");
        return wait.until(condition);
    }
}
