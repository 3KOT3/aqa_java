package ru.bulgakov.webshop;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest {

    private static final Faker faker = new Faker();
    String password = faker.harryPotter().character() + faker.number().positive();

    @Test
    void registrationTest() {
        open("https://demowebshop.tricentis.com/");
        $("a.ico-register").click();
        $("div.page-title").shouldHave(text("Register"));
        $("input#gender-male").click();
        $("input#FirstName").setValue(faker.name().firstName());
        $("input#LastName").setValue(faker.name().lastName());
        $("input#Email").setValue(faker.internet().emailAddress());
        $("input#Password").setValue(password);
        $("input#ConfirmPassword").setValue(password);
        $("input#register-button").click();


    }
}
