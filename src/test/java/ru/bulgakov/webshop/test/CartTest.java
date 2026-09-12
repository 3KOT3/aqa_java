package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.Steps.AuthSteps;
import ru.bulgakov.webshop.pages.WsRegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_REGISTRATION_URL;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_URL;

public class CartTest {
    private static final Faker faker = new Faker();
    private final AuthSteps authSteps = new AuthSteps();

    @BeforeEach
    void beforeEach() {
        authSteps.registerNewUser();
    }

    @Test
    void itemToCardTest() {

        open(WEB_SHOP_URL);
        $$("ul.top-menu li a").get(1).hover(); // навести на выпадающий список
        $(byText("Desktops")).click();
        $$("div.product-grid div").get(0).click();

        String itemName = $("[itemprop=name]").getText(); // взять текст
        String itemPrice = $("[itemprop=price]").getText();
        String itemQuantity = "2";

        $$("dl dd ul").get(0).$$("li input").get(0).click();
        $("input.qty-input").setValue(itemQuantity);
        $("input.add-to-cart-button").click();
        $("p.content").shouldBe(visible); // проверить что элемент виден
        $("span.cart-qty").shouldHave(text(itemQuantity));
        $$("a.ico-cart").get(0).click();
        $("a.product-name").shouldHave(text(itemName));
        String itemQuantityInCard = $("input.qty-input").getAttribute("value");
        assertEquals(itemQuantity, itemQuantityInCard); // проверка что значения переменных равны между собой
        $("span.product-subtotal").shouldHave(text(String.valueOf(
                Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity)
        )));

    }
}
