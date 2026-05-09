package automation;

import automation.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;

    @Test
    public void testSuccessfulLogin() {
        driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.login("admin@example.com", "Neop2020!");
        loginPage.waitForUrlToChange();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
