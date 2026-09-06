package ru.bulgakov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WikipediaResutSeacrh {
    private final SelenideElement categoriesInformation = $(".mw-normal-catlinks ul li a");
    private final ElementsCollection listEngines = $$("li[id^='mwA']");
    private final SelenideElement pageTool = $("#vector-page-tools-dropdown-checkbox");
    private final SelenideElement quoteTool = $("#t-cite");


    public WikipediaResutSeacrh ArticlePage(String articleСategory) {
        categoriesInformation.shouldHave(text(articleСategory));
        return this;
    }

    public WikipediaResutSeacrh verificationInformation(String engines, String marketShare) {
        listEngines.findBy(text(engines)).shouldHave(text(marketShare));
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

