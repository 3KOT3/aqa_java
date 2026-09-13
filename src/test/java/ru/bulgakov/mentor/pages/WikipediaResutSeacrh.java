package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WikipediaResutSeacrh {
    private final SelenideElement title = $("#firstHeading");
    private final ElementsCollection searchEngineShares = $$("#mw-content-text li");
    private final SelenideElement pageTool = $("#vector-page-tools-dropdown-checkbox");
    private final SelenideElement quoteTool = $("#t-cite");


    public WikipediaResutSeacrh checkTitle(String expectedTitle) {
        title.shouldHave(text(expectedTitle));
        return this;
    }

    public WikipediaResutSeacrh verificationInformation(String engines, String marketShare) {
        searchEngineShares .findBy(text(engines)).shouldHave(text(marketShare));
        return this;
    }

    public WikipediaResutSeacrh ToolsOfThePage() {
        pageTool.click();
        return this;
    }

    public WikipediaQouteArticle selectQuoteTool() {
        quoteTool.click();
        return page(WikipediaQouteArticle.class);
    }


}

