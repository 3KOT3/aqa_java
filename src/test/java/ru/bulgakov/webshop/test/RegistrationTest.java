package ru.bulgakov.webshop.test;

import io.qameta.allure.*;
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
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_URL;

public class RegistrationTest extends TestBase {

    private static final Faker faker = new Faker();
    String password = faker.harryPotter().character() + faker.number().positive();
    String email = faker.internet().emailAddress();


    @Test
    @Owner("s.shikshin")
    @DisplayName("Регистрация нового пользователя")
    @Tag("pozitive")
    @Severity(CRITICAL)
    @Epic("Личный кабинетпользователя")
    @Feature("Регитсрация пользователя")
    @Story("Авторизация и аутентификация пользователя")
    @Link("ссылка на задачу")
    @DisabledOnOs(OS.MAC)
    @Description("Создаём нового пользователя со случайными данными через интерфейс")
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
                .confirmPasswordInput("1234")
                .submitRegistration()
                .checkRegistrarionCompleted()
                .checkUserLogIn(email);
    }
}
