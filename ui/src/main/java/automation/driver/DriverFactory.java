package automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver createDriver(BrowserType browserType) {
        return switch (browserType) {
            case CHROME -> new ChromeDriver();
            case EDGE -> new EdgeDriver();
        };
    }
}
