package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import ru.bulgakov.webshop.TestBase;
import ru.bulgakov.webshop.pages.WsWelcomPage;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_URL;

public class RegistrationTest extends TestBase {

    private static final Faker faker = new Faker();
    String password = faker.harryPotter().character() + faker.number().positive();
    String email = faker.internet().emailAddress();


    @Test
    @DisplayName("Регистрация нового пользователя")
    @Tag("pozitive")
    @DisabledOnOs(OS.MAC)
    void registrationTest() {
        open(WEB_SHOP_URL, WsWelcomPage.class)
                .openRegistration()
                .verifyRegistrationOpened()
                .registerButton()
                .selectGenderMale()
                .enterFirstName(faker.name().firstName())
                .enterLastName(faker.name().lastName())
                .enterEmail(email)
                .enterPassword(password)
                .confirmPasswordInput(password)
                .submitRegistration()
                .checkRegistrarionCompleted()
                .checkUserLogIn(email);
    }
}
