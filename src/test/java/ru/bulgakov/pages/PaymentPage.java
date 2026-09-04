package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage extends BasePage {

    private final SelenideElement priceAmount = $("[class*='prices']");

    public PaymentPage checkPriceAmount(String expectedAmount) {
        priceAmount.shouldHave(text(expectedAmount));

        return this;
    }
}
