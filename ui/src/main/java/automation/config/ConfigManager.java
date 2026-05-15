package automation.config;

import org.aeonbits.owner.ConfigFactory;

public final class ConfigManager {

    private static final FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

    private ConfigManager() {
    }

    public static FrameworkConfig config() {
        return config;
    }
}
