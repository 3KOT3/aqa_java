package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class WsCartPage {

    private final SelenideElement itemNameCart = $("a.product-name");
    private final SelenideElement quantityCart = $("input.qty-input");
    private final SelenideElement totalAmountCart = $("span.product-subtotal");

    public WsCartPage checkItemNameInCart(String itemName) {
        itemNameCart.shouldHave(text(itemName));
        return this;
    }

    public String saveQuantityInCart() {
        String text = quantityCart.getAttribute("value");
        return text;
    }

    public WsCartPage CheckTotalAmountInCart(String itemPrice, String itemQuantity) {
        totalAmountCart.shouldHave(text(String.valueOf(
                Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity))));
        return this;
    }
}

