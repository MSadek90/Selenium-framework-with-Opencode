package automation.pageobjects;

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
        driver.get(ConfigManager.config().baseUrl());
        driver.manage().window().maximize();
    }

    public void enterEmail(String email) {
        wait.waitForVisible(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmit() {
        wait.waitForClickable(submitButton).click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }

    public void waitForUrlToChange() {
        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlToBe(ConfigManager.config().baseUrl())));
    }
}
