package automation;

import automation.driver.DriverManager;
import automation.pageobjects.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
@Epic("Authentication")
@Feature("Login")
public class LoginTest {

    @BeforeMethod
    public void setUp() {
        log.info("=== Test Setup: Initializing driver ===");
        DriverManager.initDriver();
    }

    @Test(groups = {"smoke", "sanity", "regression"})
    @Story("Successful login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can log in with valid email and password")
    public void testSuccessfulLogin() {
        log.info("=== Test: testSuccessfulLogin ===");
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());

        loginPage.open();
        loginPage.login("admin@example.com", "Neop2020!");
        loginPage.waitForUrlToChange();
        log.info("=== Test: testSuccessfulLogin - PASSED ===");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("=== Test Teardown: Quitting driver ===");
        DriverManager.quitDriver();
    }
}
