package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class WsCartPage {

    private final SelenideElement itemNameCart = $("a.product-name");
    private final SelenideElement quantityCart = $("input.qty-input");
    private final SelenideElement totalAmountCart = $("span.product-subtotal");
    private final SelenideElement unitPriceCart = $("span.product-unit-price");


    public WsCartPage checkItemNameInCart(String itemName) {
        itemNameCart.shouldHave(text(itemName));
        return this;
    }

    public String saveQuantityInCart() {
        String text = quantityCart.getAttribute("value");
        return text;
    }

    public WsCartPage CheckTotalAmountInCart(String itemPrice, String itemQuantity) {
        totalAmountCart.shouldHave(exactText(String.valueOf(
                Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity))));
        return this;
    }

    public String getItemName(){
      return itemNameCart.getText();
    }

    public String getQuantity() {
        return quantityCart.getValue();
    }

    public String getSubtotal(){
        return totalAmountCart.getText();
    }

    public String getUnitPrice() {
        return unitPriceCart.getText();
    }

}

