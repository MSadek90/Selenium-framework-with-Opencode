package automation.pageobjects;

import automation.config.ConfigManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
public class LoginPage extends BasePage {

    private final By emailInput = By.cssSelector("input[type='email']");
    private final By passwordInput = By.cssSelector("input[type='password']");
    private final By submitButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = ConfigManager.config().baseUrl();
        log.info("Navigating to URL: {}", url);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void enterEmail(String email) {
        log.info("Entering email: {}", email);
        wait.waitForVisible(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        log.info("Entering password");
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmit() {
        log.info("Clicking submit button");
        wait.waitForClickable(submitButton).click();
    }

    public void login(String email, String password) {
        log.info("Logging in with email: {}", email);
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }

    public void waitForUrlToChange() {
        log.info("Waiting for URL to change from: {}", ConfigManager.config().baseUrl());
        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlToBe(ConfigManager.config().baseUrl())));
        log.info("URL changed successfully");
    }
}
