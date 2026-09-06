package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class YandexSearchResultsPage {

    private final SelenideElement closeWindow = $(".DistributionButtonClose");

    public YandexSearchResultsPage closeDefaultBrowserSelectWindow() {
        if ((closeWindow).exists()) {
            (closeWindow).shouldBe(interactable, Duration.ofSeconds(4)).click();
        }
        return this;
    }

    public WelcomPage openLink(String webSiteName) {
        $(byText(webSiteName)).click();
        return page(WelcomPage.class);
    }
}