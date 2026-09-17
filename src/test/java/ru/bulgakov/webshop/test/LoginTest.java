package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.bulgakov.webshop.TestBase;
import ru.bulgakov.webshop.pages.WsLoginPage;
import ru.bulgakov.webshop.pages.WsRegistrationPage;
import ru.bulgakov.webshop.pages.WsWelcomPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static ru.bulgakov.webshop.config.Config.*;

public class LoginTest extends TestBase {
    private static final Faker faker = new Faker();
    private String email;
    private String password;


    @Nested
    public class PositiveTest {
        @BeforeEach
        void beforeAll() {
            password = faker.harryPotter().character() + faker.number().positive();
            email = faker.internet().emailAddress();

            open(WEB_SHOP_REGISTRATION_URL, WsRegistrationPage.class)
                    .register(
                            faker.name().firstName(),
                            faker.name().lastName(),
                            email,
                            password)
                    .checkUserLogIn(email);

            clearBrowserCookies(); // очистка куков барузера
            clearBrowserLocalStorage(); // очистка всего localStorage
        }

        @Test
        @DisplayName("Авторизация пользователя")
        @Tag("pozitive")
        @DisabledOnOs(OS.MAC)
        void succesLoginTest() {

            open(WEB_SHOP_URL, WsWelcomPage.class)
                    .openLogin()
                    .checkLoginPageOpened()
                    .enterEmail(email)
                    .enterPassword(password)
                    .checkRememberMe()
                    .submitLogin()
                    .checkUserLoginIn(email);
        }
    }


    @ParameterizedTest(name = "{0}")
    @CsvFileSource(resources = "/invalid_email.csv")
    @Tag("negative")
    @DisplayName("Аторизация с невалидным email")
    @DisabledOnOs(OS.MAC)
    void invalidEmailLoginTest(String email) {
        open(WEB_SHOP_LOGIN_URL, WsLoginPage.class)
                .checkLoginPageOpened()
                .enterEmail(email)
                .enterPassword("password")
                .verifyEmailValidationErrorAppear()
                .submitLogin();
    }
}
