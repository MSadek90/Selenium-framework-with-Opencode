package automation;

import static automation.util.AllureLogger.step;

import automation.util.FakeDataUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Demo")
@Feature("FakeData")
public class FakeDataDemoTest {

    @Test
    @Story("Generate fake test data")
    @Severity(SeverityLevel.MINOR)
    @Description("Demonstrate DataFaker-generated dummy values")
    public void testGenerateFakeData() {
        String name = FakeDataUtil.getName();
        String email = FakeDataUtil.getEmail();
        String phone = FakeDataUtil.getPhone();

        step("Generated fake name: {}", name);
        step("Generated fake email: {}", email);
        step("Generated fake phone: {}", phone);
    }
}
