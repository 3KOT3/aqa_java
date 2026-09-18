package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class WsProductPage {

    private final SelenideElement itemPrice = $("[itemprop=price]");
    private final SelenideElement quantityInput = $("input.qty-input");
    private final SelenideElement buttonAddToCart = $("input.add-to-cart-button");
    private final SelenideElement barNotification = $("div#bar-notification");
    private final SelenideElement cartQuantityBadge = $("span.cart-qty");
    private final SelenideElement cartLink = $("#topcartlink a");
    private final SelenideElement attributes = $("div.attributes");

    public WsProductPage selectProcessor(String processor) {
        attributeOptions("Processor")
                .findBy(text(processor))
                .$("input")
                .click();
        return this;
    }

    private ElementsCollection attributeOptions(String groupTitle) {
        return attributes.$$("dl dt")
                .findBy(text(groupTitle))
                .sibling(0)
                .$$("li");
    }

    public WsProductPage setQuantity(String quantity) {
        quantityInput.clear();
        quantityInput.setValue(quantity);
        return this;
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public WsProductPage clickAddToCart() {
        buttonAddToCart.click();
        return this;
    }

    public WsProductPage checkNotificationAddCart() {
        barNotification.shouldBe(visible)
                .shouldHave(cssClass("success"))
                .shouldHave(text("The product has been added to your shopping cart"));
        return this;
    }

    public WsProductPage checkQuantityCartInHeader(String quantity) {
        cartQuantityBadge.shouldHave(exactText("(" + quantity + ")"));
        return this;
    }

    public WsCartPage openCart() {
        cartLink.click();
        return page(WsCartPage.class);
    }
}