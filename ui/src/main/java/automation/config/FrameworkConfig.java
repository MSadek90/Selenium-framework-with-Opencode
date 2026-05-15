package automation.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface FrameworkConfig extends Config {

    @Key("base.url")
    String baseUrl();

    @Key("browser")
    String browser();

    @Key("explicit.wait")
    int explicitWait();

    @Key("page.load.timeout")
    int pageLoadTimeout();
}
