package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WsLoginPage {

    private final SelenideElement checkLoginOpened = $("div.page-title h1");

    public WsLoginPage checkLoginPageOpened() {
        checkLoginOpened.shouldHave(text("Welcome, Please Sign In!"));
        return this;
    }

}
