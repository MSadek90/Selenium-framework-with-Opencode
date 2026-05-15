package automation.util;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.helpers.MessageFormatter;

@Slf4j
public final class AllureLogger {

    private AllureLogger() {
    }

    public static void step(String message, Object... args) {
        String formatted = MessageFormatter.arrayFormat(message, args).getMessage();
        log.info(formatted);
        Allure.step(formatted, () -> {});
    }
}
