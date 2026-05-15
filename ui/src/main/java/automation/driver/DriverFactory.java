package automation.driver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

@Slf4j
public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver createDriver(BrowserType browserType) {
        log.info("Creating driver for browser: {}", browserType);
        return switch (browserType) {
            case CHROME -> {
                log.debug("Initializing ChromeDriver");
                yield new ChromeDriver();
            }
            case EDGE -> {
                log.debug("Initializing EdgeDriver");
                yield new EdgeDriver();
            }
        };
    }
}
