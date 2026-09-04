package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexSearchResultsPage extends BasePage {

    private static final Duration BANNER_TIMEOUT = Duration.ofSeconds(3);

    private final SelenideElement distributionBannerClose = $(".DistributionButtonClose");

    public YandexSearchResultsPage closeDistributionBannerIfAppeared() {
        if (distributionBannerClose.is(visible, BANNER_TIMEOUT)) {
            distributionBannerClose.click(usingJavaScript());
        }

        return this;
    }

    public YandexSearchResultsPage openLink(String webSiteName) {
        $$("a[href*='" + webSiteName + "']").filterBy(visible)
                .first()
                .click();

        return this;
    }
}
