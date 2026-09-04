package ru.bulgakov.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.$$;

public class CitePage extends BasePage {

    private final ElementsCollection citationStyleHeaders = $$(".mw-heading3");

    public CitePage checkCitationStyle(String expectedStyle) {
        citationStyleHeaders.shouldHave(itemWithText(expectedStyle));

        return this;
    }
}
