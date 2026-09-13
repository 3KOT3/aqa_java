package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class WsProductPage {

    private final SelenideElement itemName = $("[itemprop=name]");
    private final SelenideElement itemPrice = $("[itemprop=price]");
    private final ElementsCollection levelProcessor = $$("dd ul.option-list label");
    private final SelenideElement quantityProcessor = $("input.qty-input");
    private final SelenideElement buttonCart = $("input.add-to-cart-button");
    private final SelenideElement checkNotificationCart = $("p.content");
    private final SelenideElement checkQuantityCart = $("span.cart-qty");
    private final SelenideElement linkCartHeader = $("#topcartlink");


    private static final Pattern SURCHARGE_PATTERN = Pattern.compile("\\[\\+([0-9.]+)\\]");
    private String plusPrice = "0";


    public WsProductPage selectProcessorAndQuantity(String processor, String quantity) {
        SelenideElement optionLabel = levelProcessor.findBy(partialText(processor));
        optionLabel.click();
        String labelText = optionLabel.getText();
        Matcher m = SURCHARGE_PATTERN.matcher(labelText);
        plusPrice = m.find() ? m.group(1) : "0";
        quantityProcessor.setValue(quantity);
        return this;
    }

    public String getPlusPrice() {
        return plusPrice;
    }

    public String saveItemName() {
        String text = itemName.getText();
        return text;
    }

    public String saveItemPrice() {
        float base = Float.parseFloat(itemPrice.getText());
        float plus = Float.parseFloat(plusPrice);
        return String.valueOf(base + plus);
    }

    public WsProductPage bottonAddToCard() {
        buttonCart.click();
        return this;
    }

    public WsProductPage checkNotificationAddCart() {
        checkNotificationCart.shouldBe(visible);
        return this;
    }

    public WsProductPage checkQuantityCartInHeader(String quantityHeader) {
        checkQuantityCart.shouldHave(text(quantityHeader));
        return this;
    }

    public WsCartPage LinkCartInHeader() {
        linkCartHeader.click();
        return page(WsCartPage.class);
    }


}
