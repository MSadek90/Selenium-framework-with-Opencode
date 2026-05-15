package automation.pageobjects;

import automation.util.WaitUtil;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WaitUtil wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }
}
