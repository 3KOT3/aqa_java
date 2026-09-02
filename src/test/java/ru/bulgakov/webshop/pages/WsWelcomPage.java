package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class WsWelcomPage {
    private final SelenideElement registerButton = $("a.ico-register");
    private final SelenideElement buttonLogin = $(".ico-login");

    public WsRegistrationPage openRegistration() {
        registerButton.click();
        return page(WsRegistrationPage.class);

    }

    public WsLoginPage openLogin() {
        buttonLogin.click();
        return page(WsLoginPage.class);
    }

}
