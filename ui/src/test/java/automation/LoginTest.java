package automation;

import automation.driver.DriverManager;
import automation.pageobjects.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());

        loginPage.open();
        loginPage.login("admin@example.com", "Neop2020!");
        loginPage.waitForUrlToChange();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
