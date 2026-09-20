package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.$$;

public class WikipediaQouteArticle {

    private final ElementsCollection styleGost = $$(".mw-heading3");

    @Step("Проверка госта {gost}")
    public WikipediaQouteArticle checkingGostPageQoute(String gost){
        styleGost.shouldHave(itemWithText(gost));
        return this;
    }
}
