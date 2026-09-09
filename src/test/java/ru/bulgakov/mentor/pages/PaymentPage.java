package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {

    private final SelenideElement validatorAmount =  $(".styles-module-scss-module__kWKzya__prices");


    public PaymentPage validatorAmountPage (String amount){
        validatorAmount.shouldHave(text(amount));
        return this;
    }
}
