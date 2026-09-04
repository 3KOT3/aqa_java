package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class WikipediaMainPage extends BasePage {

    private final SelenideElement searchInput = $("#searchInput"),
            searchButton = $(".cdx-search-input__end-button");

    public WikipediaArticlePage search(String query) {
        searchInput.setValue(query);
        searchButton.click();

        return page(WikipediaArticlePage.class);
    }
}
