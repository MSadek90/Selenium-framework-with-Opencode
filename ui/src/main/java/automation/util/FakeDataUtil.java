package automation.util;

import net.datafaker.Faker;

public final class FakeDataUtil {

    private static final Faker FAKER = new Faker();

    private FakeDataUtil() {
    }

    public static String getName() {
        return FAKER.name().fullName();
    }

    public static String getEmail() {
        return FAKER.internet().emailAddress();
    }

    public static String getPhone() {
        return FAKER.phoneNumber().cellPhone();
    }
}
