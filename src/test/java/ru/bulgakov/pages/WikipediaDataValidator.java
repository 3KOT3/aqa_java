package ru.bulgakov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WikipediaDataValidator {


    private final SelenideElement google = $("#mwAU8");
    private final SelenideElement bing = $("#mwAVE");
    private final SelenideElement yahoo = $("#mwAVM");
    private final SelenideElement instriments = $("#vector-page-tools-dropdown-checkbox");
    private final SelenideElement insrumentsQuoteTool = $("#t-cite");
    private final ElementsCollection stilesGost = $$(".mw-heading3");

    public WikipediaDataValidator dataValidatorGoogle(String text) {
        google.shouldHave(text(text));
        return this;
    }

    public WikipediaDataValidator dataValidatorBing(String text) {
        bing.shouldHave(text(text));
        return this;
    }

    public WikipediaDataValidator dataValidatorYahoo(String text) {
        yahoo.shouldHave(text(text));
        return this;
    }

    public WikipediaDataValidator clickInstruments() {
        instriments.click();
        return this;
    }

    public WikipediaDataValidator selectInstrumentsQuoteTool() {
        insrumentsQuoteTool.click();
        return this;
    }

    public WikipediaDataValidator stilesGostBiographyLink(String text) {
        stilesGost.get(0).shouldHave(text(text));
        return this;

    }
}
