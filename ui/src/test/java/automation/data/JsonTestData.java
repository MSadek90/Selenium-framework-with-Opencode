package automation.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class JsonTestData {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static Map<String, Object> data;

    static {
        try (InputStream is = JsonTestData.class
                .getClassLoader().getResourceAsStream("users.json")) {
            if (is == null) {
                throw new RuntimeException("users.json not found on classpath");
            }
            data = MAPPER.readValue(is, Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load users.json", e);
        }
    }

    private JsonTestData() {
    }

    @SuppressWarnings("unchecked")
    public static String getValidEmail() {
        Map<String, Object> user = (Map<String, Object>) data.get("validUser");
        return (String) user.get("email");
    }

    @SuppressWarnings("unchecked")
    public static String getValidPassword() {
        Map<String, Object> user = (Map<String, Object>) data.get("validUser");
        return (String) user.get("password");
    }
}
