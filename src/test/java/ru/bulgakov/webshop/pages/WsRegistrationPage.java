package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsRegistrationPage {
    private final SelenideElement registerButton = $("a.ico-register");
    private final SelenideElement pageTitle = $("div.page-title");
    private final SelenideElement mailGenderRadio = $("input#gender-male");
    private final SelenideElement firstNameInput = $("input#FirstName");
    private final SelenideElement lastNameInput = $("input#LastName");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement confirmInput = $("input#ConfirmPassword");
    private final SelenideElement submitRagistrationButton = $("input#register-button");
    private final SelenideElement resultText = $("div.result");
    private final ElementsCollection headerLinks = $$("div.header-links ul li a");


    public WsRegistrationPage registerButton() {
        registerButton.click();
        return this;
    }

    public WsRegistrationPage verifyRegistrationOpened() {
        pageTitle.shouldHave(text("Register"));
        return this;
    }

    public WsRegistrationPage selectGenderMale() {
        mailGenderRadio.click();
        return this;
    }

    public WsRegistrationPage enterFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public WsRegistrationPage enterLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public WsRegistrationPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public WsRegistrationPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public WsRegistrationPage confirmPasswordInput(String password) {
        confirmInput.setValue(password);
        return this;
    }

    public WsRegistrationPage submitRegistration() {
        submitRagistrationButton.click();
        return this;
    }

    public WsRegistrationPage checkRegistrarionCompleted() {
        resultText.shouldHave(text("Your registration completed"));
        return this;
    }

    public WsRegistrationPage checkEmailIsShown(String email) {
        headerLinks.get(0).shouldHave(text(email));
        return this;
    }
}
