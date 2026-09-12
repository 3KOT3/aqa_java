package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WsLoginPage {

    private final SelenideElement checkLoginOpened = $("div.page-title h1");
    private final SelenideElement inputEmail = $("input#Email");
    private final SelenideElement inputPassword = $("input#Password");
    private final SelenideElement checkRemember = $("#RememberMe");
    private final ElementsCollection checkLoginIn = $$("div.header-links ul li a");

    public WsLoginPage checkLoginPageOpened() {
        checkLoginOpened.shouldHave(text("Welcome, Please Sign In!"));
        return this;
    }

    public WsLoginPage enterEmail(String email) {
        inputEmail.setValue(email);
        return this;
    }

    public WsLoginPage enterPassword(String password) {
        inputPassword.setValue(password);
        return this;
    }

    public WsWelcomPage checkRememberMe() {
        checkRemember.click();
        return page(WsWelcomPage.class);
    }

    public WsLoginPage checkUserLoginIn(String email) {
        checkLoginIn.get(0).shouldHave(text(email));
        return this;
    }

}
