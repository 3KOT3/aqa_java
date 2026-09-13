package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class WsProductListPage {

    private final ElementsCollection productList = $$("div.product-grid div");

    public WsProductPage selectProduct(int index) {
        productList.get(index).click();
        return page(WsProductPage.class);
    }

}
