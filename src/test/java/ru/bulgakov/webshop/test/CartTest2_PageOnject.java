package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import ru.bulgakov.webshop.steps.AuthSteps;
import ru.bulgakov.webshop.TestBase;
import ru.bulgakov.webshop.pages.WsCartPage;
import ru.bulgakov.webshop.pages.WsProductPage;
import ru.bulgakov.webshop.pages.WsWelcomPage;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_URL;
import static ru.bulgakov.webshop.pages.WsProductListPage.PRODUCT_NAME;

public class CartTest2_PageOnject extends TestBase {
    private static final Faker faker = new Faker();
    private final AuthSteps authSteps = new AuthSteps();

    @BeforeEach
    void beforeEach() {
        authSteps.registerNewUser();
    }

    @Test
    @DisplayName("Добавление товара в корзину PageObject")
    @Tag("pozitive")
    @DisabledOnOs(OS.MAC)
    void itemToCardTest() {

        String processor = "Medium";
        String itemQuantity = "4";

        WsProductPage productPage = open(WEB_SHOP_URL, WsWelcomPage.class)
                .categoryProducts("Computers")
                .selectSubCategory("Desktops")
                .openProduct(PRODUCT_NAME);

        float expectedUnitPrice = Float.parseFloat(productPage.getItemPrice())
                + processorSurcharge(processor);

        WsCartPage cartPage = productPage
                .selectProcessor(processor)
                .setQuantity(itemQuantity)
                .clickAddToCart()
                .checkNotificationAddCart()
                .checkQuantityCartInHeader(itemQuantity)
                .openCart();

        String expectedUnitPriceText = String.format(Locale.US, "%.2f", expectedUnitPrice);
        String expectedSubtotalText = String.format(Locale.US, "%.2f",
                expectedUnitPrice * Float.parseFloat(itemQuantity));

        assertAll(
                () -> assertEquals(PRODUCT_NAME, cartPage.getItemName()),
                () -> assertEquals(itemQuantity, cartPage.getQuantity()),
                () -> assertEquals(expectedUnitPriceText, cartPage.getUnitPrice()),
                () -> assertEquals(expectedSubtotalText, cartPage.getSubtotal())
        );
    }
    private float processorSurcharge(String processor) {
        return switch (processor) {
            case "Slow" -> 0f;
            case "Medium" -> 15f;
            case "Fast" -> 100f;
            default -> throw new IllegalArgumentException("Unknown processor: " + processor);
        };
    }
}
