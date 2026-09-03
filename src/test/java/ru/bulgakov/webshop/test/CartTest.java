package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.Steps.AuthSteps;
import ru.bulgakov.webshop.pages.WsRegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_REGISTRATION_URL;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_URL;

public class CartTest {
    private static final Faker faker = new Faker();
    private final AuthSteps authSteps = new AuthSteps();

    @BeforeEach
    void beforeEach() {
        authSteps.registerNewUser();

    }

    @Test
    void itemToCardTest() {

        open(WEB_SHOP_URL);

        System.out.println(1);

    }
}
