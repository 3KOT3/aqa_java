package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class WsProductListPage {

    private final ElementsCollection productList = $$("div.product-grid div");
    private final ElementsCollection productLinks = $$("h2.product-title a");
    public static final String PRODUCT_NAME = "Build your own cheap computer";

    public WsProductPage selectProduct(int index) {
        productList.get(index).click();
        return page(WsProductPage.class);
    }

    public WsProductPage openProduct(String productName) {
        productLinks.findBy(exactText(productName)).click();
        return page(WsProductPage.class);
    }
}
