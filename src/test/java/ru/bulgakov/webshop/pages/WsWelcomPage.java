package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WsWelcomPage {
    private final SelenideElement registerButton = $("a.ico-register");
    private final SelenideElement buttonLogin = $(".ico-login");
    private final SelenideElement inputLoginButton = $("input.login-button");
    private final ElementsCollection categoryProductMenu = $$("ul.top-menu li a");

    @Step("Открыть страницу регистрации")
    public WsRegistrationPage openRegistration() {
        registerButton.click();
        return page(WsRegistrationPage.class);

    }

    @Step("Нажать кнопку авторизации")
    public WsLoginPage openLogin() {
        buttonLogin.click();
        return page(WsLoginPage.class);
    }

    public WsLoginPage submitLogin() {
        inputLoginButton.click();
        return page(WsLoginPage.class);
    }

    @Step("Выбрать категорию товаров {category}")
    public WsWelcomPage categoryProducts(String category) {
        categoryProductMenu.findBy(text(category)).hover();
        return this;
    }

    @Step("Выбрать подкатегорию товаров {subCategory}")
    public WsProductListPage selectSubCategory(String subCategory) {
        categoryProductMenu.findBy(text(subCategory)).hover().click();
        return page(WsProductListPage.class);
    }

}
