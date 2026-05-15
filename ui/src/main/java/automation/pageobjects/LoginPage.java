package automation.pageobjects;

import static automation.util.AllureLogger.step;

import automation.config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By emailInput = By.cssSelector("input[type='email']");
    private final By passwordInput = By.cssSelector("input[type='password']");
    private final By submitButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = ConfigManager.config().baseUrl();
        step("Navigating to URL: {}", url);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void enterEmail(String email) {
        step("Entering email: {}", email);
        wait.waitForVisible(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        step("Entering password");
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmit() {
        step("Clicking submit button");
        wait.waitForClickable(submitButton).click();
    }

    public void login(String email, String password) {
        step("Logging in with email: {}", email);
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }

    public void waitForUrlToChange() {
        step("Waiting for URL to change from: {}", ConfigManager.config().baseUrl());
        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlToBe(ConfigManager.config().baseUrl())));
        step("URL changed successfully");
    }
}
