package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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


    public WsRegistrationPage register(String FirstName, String LastName, String email, String password) {
        registerButton()
                .selectGenderMale()
                .enterFirstName(FirstName)
                .enterLastName(LastName)
                .enterEmail(email)
                .enterPassword(password)
                .confirmPasswordInput(password)
                .submitRegistration()
                .checkRegistrarionCompleted();
        return this;
    }

    @Step("Нажать кнопку регистрации")
    public WsRegistrationPage registerButton() {
        registerButton.click();
        return this;
    }

    @Step("Проверка нахождения на странице регистрации")
    public WsRegistrationPage verifyRegistrationOpened() {
        pageTitle.shouldHave(text("Register"));
        return this;
    }

    @Step("Выбрать пол")
    public WsRegistrationPage selectGenderMale() {
        mailGenderRadio.click();
        return this;
    }

    @Step("Ввести имя")
    public WsRegistrationPage enterFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Ввести фамилию")
    public WsRegistrationPage enterLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Ввести адрес электронной почты {email}")
    public WsRegistrationPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Ввести адрес пароль {password}")
    public WsRegistrationPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Повторить ведённый пароль {password}")
    public WsRegistrationPage confirmPasswordInput(String password) {
        confirmInput.setValue(password);
        return this;
    }

    @Step("Нажать кнопку для регистрации")
    public WsRegistrationPage submitRegistration() {
        submitRagistrationButton.click();
        return this;
    }

    @Step("Проверить успешность регистрации")
    public WsRegistrationPage checkRegistrarionCompleted() {
        resultText.shouldHave(text("Your registration completed"));
        return this;
    }

    @Step("Проверить email после успешной регистрации")
    public WsRegistrationPage checkUserLogIn(String email) {
        headerLinks.get(0).shouldHave(text(email));
        return this;
    }
}
