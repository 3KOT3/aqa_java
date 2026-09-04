package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class WikipediaArticlePage extends BasePage {

    private final SelenideElement title = $("#firstHeading"),
            articleContent = $("#mw-content-text"),
            pageToolsDropdown = $("#vector-page-tools-dropdown-checkbox"),
            citePageLink = $("#t-cite");

    public WikipediaArticlePage checkTitle(String expectedTitle) {
        title.shouldHave(text(expectedTitle));

        return this;
    }

    public WikipediaArticlePage checkSearchEngineShare(String expectedShare) {
        articleContent.shouldHave(text(expectedShare));

        return this;
    }

    public WikipediaArticlePage openPageTools() {
        pageToolsDropdown.click();

        return this;
    }

    public CitePage openCitePage() {
        citePageLink.click();

        return page(CitePage.class);
    }
}
