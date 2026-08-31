package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class YandexSearchPage {

    private final SelenideElement searchInput = $("#text");

    public YandexSearchResultsPage search(String query) {
        searchInput.setValue(query).pressEnter();
        return page(YandexSearchResultsPage.class);
    }
}
