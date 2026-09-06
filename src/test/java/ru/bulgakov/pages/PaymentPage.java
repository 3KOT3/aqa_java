package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {

    private final SelenideElement validatorAmount =  $(".styles-module-scss-module__kWKzya__prices");
    private final SelenideElement selectCurrency =  $("span.ant-select-selection-wrap");

    public PaymentPage validatorAmountPage (String amount){
        validatorAmount.shouldHave(text(amount));
        return this;
    }

    public PaymentPage selectPaymentCurrency() {
        selectCurrency.click();
        return this;
    }

    public PaymentPage selectCurrency(String currency) {
        $(byText(currency));
        return this;
    }
}
