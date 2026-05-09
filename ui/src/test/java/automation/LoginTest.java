package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;

    @Test
    public void testSuccessfulLogin() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://abajora-dashboard.neop.co/ar/admin/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")))
                .sendKeys("admin@example.com");

        driver.findElement(By.cssSelector("input[type='password']"))
                .sendKeys("Neop2020!");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlToBe("https://abajora-dashboard.neop.co/ar/admin/login")));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
