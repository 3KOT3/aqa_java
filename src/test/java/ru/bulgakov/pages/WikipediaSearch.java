package ru.bulgakov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class WikipediaSearch {

    private final ElementsCollection searchInput = $$(".cdx-text-input__input");
    private final ElementsCollection clickButton = $$(".cdx-button--weight-normal");

    public WikipediaSearch search(String text) {
        searchInput.get(0).setValue(text);
        return this;
    }

    public WikipediaDataValidator clickButtonSearch() {
        clickButton.get(0).click();
        return page(WikipediaDataValidator.class);
    }
}
