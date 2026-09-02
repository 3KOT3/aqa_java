package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.pages.WsWelcomPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {
    private static final Faker faker = new Faker();


    @Test
    void succesLoginTest() {

        String password = faker.harryPotter().character() + faker.number().positive();
        String email = faker.internet().emailAddress();

        open("https://demowebshop.tricentis.com/", WsWelcomPage.class)
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

        clearBrowserCookies();
        clearBrowserLocalStorage();

        open("https://demowebshop.tricentis.com/", WsWelcomPage.class)
                .openLogin()
                .checkLoginPageOpened()
        $("input#Email").setValue(email);
        $("input#Password").setValue(password);
        $("#RememberMe").click();
        $("input.login-button").click();
        $$("div.header-links ul li a").get(0).shouldHave(text(email));

        System.out.println(1);
    }
}
