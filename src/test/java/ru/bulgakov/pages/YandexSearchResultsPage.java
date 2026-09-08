package ru.bulgakov.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class YandexSearchResultsPage {

    private static final Duration BANNER_TIMEOUT = Duration.ofSeconds(3);
    private final SelenideElement closeWindow = $(".DistributionButtonClose");


    public YandexSearchResultsPage closeDistributionBannerIfAppeared() {
        if (closeWindow.is(visible, BANNER_TIMEOUT)) {
            closeWindow.click(usingJavaScript());
        }
        return this;
    }

    public WelcomPage openLink(String webSiteName) {
        $$("a[href*='" + webSiteName + "']").filterBy(visible)
                .first()
                .click();
        return page(WelcomPage.class);
    }

}