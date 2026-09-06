package ru.bulgakov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class WikipediaWelcomPage {

    private final ElementsCollection searchInput = $$(".cdx-text-input__input");
    private final ElementsCollection buttonSearch = $$(".cdx-button--weight-normal");

    public WikipediaWelcomPage insertInput(String text) {
        searchInput.first().setValue(text);
        return this;
    }

    public WikipediaResutSeacrh buttonSearchClick() {
        buttonSearch.first().click();
        return page(WikipediaResutSeacrh.class);

    }
}
