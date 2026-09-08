package ru.bulgakov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {

    private final SelenideElement validatorAmount =  $(".styles-module-scss-module__kWKzya__prices");
    private final SelenideElement currencyDropdown =  $("span.ant-select-selection-wrap");
    private final ElementsCollection currencyOptions =  $$(".ant-select-item-option");

    public PaymentPage validatorAmountPage (String amount){
        validatorAmount.shouldHave(text(amount));
        return this;
    }


    public PaymentPage selectCurrency(String currency) {
        currencyDropdown.click();
        currencyOptions.findBy(text(currency))
                .click();
        return this;
    }

}
