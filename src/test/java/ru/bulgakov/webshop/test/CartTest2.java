package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.Steps.AuthSteps;
import ru.bulgakov.webshop.pages.WsCartPage;
import ru.bulgakov.webshop.pages.WsProductPage;
import ru.bulgakov.webshop.pages.WsWelcomPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_URL;

public class CartTest2 {
    private static final Faker faker = new Faker();
    private final AuthSteps authSteps = new AuthSteps();

    @BeforeEach
    void beforeEach() {
        authSteps.registerNewUser();
    }

    @Test
    void itemToCardTest() {
        String itemQuantity = "4";
        String itemName;
        String itemPrice;
        String itemQuantityInCard;

        WsProductPage productPage = open(WEB_SHOP_URL, WsWelcomPage.class)
                .categoryProducts("COMPUTERS")
                .selectSubCategory("Desktops")
                .selectProduct(0)
                .selectProcessorAndQuantity("Medium", itemQuantity);
        itemName = productPage.saveItemName();
        itemPrice = productPage.saveItemPrice();
        WsCartPage cartPage = productPage
                .bottonAddToCard()
                .checkNotificationAddCart()
                .checkQuantityCartInHeader(itemQuantity)
                .LinkCartInHeader()
                .checkItemNameInCart(itemName);
        itemQuantityInCard = cartPage.saveQuantityInCart();
        assertEquals(itemQuantity, itemQuantityInCard);
        cartPage.CheckTotalAmountInCart(itemPrice,itemQuantity);
    }
}
