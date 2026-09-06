package ru.bulgakov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class WikipediaQouteArticle {

    private final ElementsCollection styleGost = $$(".mw-heading3");

    public WikipediaQouteArticle сheckingGostPageQoute(String gost){
        styleGost.first().shouldHave(text(gost));
        return this;
    }
}
