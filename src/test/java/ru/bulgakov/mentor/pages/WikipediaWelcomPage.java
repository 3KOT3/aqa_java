package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class WikipediaWelcomPage {

    private final ElementsCollection searchInput = $$(".cdx-text-input__input");
    private final ElementsCollection buttonSearch = $$(".cdx-button--weight-normal");

    @Step("Ввести запрос в окно поиска {text}")
    public WikipediaWelcomPage insertInput(String text) {
        searchInput.first().setValue(text);
        return this;
    }

    @Step("Нажать кнопку поиска")
    public WikipediaResutSeacrh buttonSearchClick() {
        buttonSearch.first().click();
        return page(WikipediaResutSeacrh.class);

    }
}
