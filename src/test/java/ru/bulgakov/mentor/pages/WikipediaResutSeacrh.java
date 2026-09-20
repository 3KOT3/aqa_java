package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WikipediaResutSeacrh {
    private final SelenideElement title = $("#firstHeading");
    private final ElementsCollection searchEngineShares = $$("#mw-content-text li");
    private final SelenideElement pageTool = $("#vector-page-tools-dropdown-checkbox");
    private final SelenideElement quoteTool = $("#t-cite");

   @Step("Проверка нахождения на нужной статье {expectedTitle}")
    public WikipediaResutSeacrh checkTitle(String expectedTitle) {
        title.shouldHave(text(expectedTitle));
        return this;
    }

    @Step("Проверка информации на странице {engines}, {marketShare}")
    public WikipediaResutSeacrh verificationInformation(String engines, String marketShare) {
        searchEngineShares .findBy(text(engines)).shouldHave(text(marketShare));
        return this;
    }

    @Step("Получить список инструментов страницы")
    public WikipediaResutSeacrh ToolsOfThePage() {
        pageTool.click();
        return this;
    }

    @Step("Выбрать инструмент цитирования")
    public WikipediaQouteArticle selectQuoteTool() {
        quoteTool.click();
        return page(WikipediaQouteArticle.class);
    }


}

