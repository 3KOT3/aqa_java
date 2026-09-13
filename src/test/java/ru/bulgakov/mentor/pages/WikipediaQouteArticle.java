package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.$$;

public class WikipediaQouteArticle {

    private final ElementsCollection styleGost = $$(".mw-heading3");

    public WikipediaQouteArticle checkingGostPageQoute(String gost){
        styleGost.shouldHave(itemWithText(gost));
        return this;
    }
}
