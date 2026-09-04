package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.bulgakov.Config;
import ru.bulgakov.pages.PaymentPage;
import ru.bulgakov.pages.WelcomePage;
import ru.bulgakov.pages.WikipediaMainPage;
import ru.bulgakov.pages.YandexSearchPage;

import static com.codeborne.selenide.Selenide.open;

public class QaTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 30000;
        Configuration.timeout = 10000;
    }

    @Test
    void coursePriceShouldBe47000Test() {
        open(Config.YANDEX_URL, YandexSearchPage.class)
                .search("bulgakov qa")
                .closeDistributionBannerIfAppeared()
                .openLink(Config.COURSE_HOST)

                // сайт курса открылся новой вкладкой
                .switchToWindow(1, WelcomePage.class)
                .openCostSection()
                .clickWantToQa()
                .clickRunToPay()

                // оплата открылась еще одной вкладкой
                .switchToWindow(2, PaymentPage.class)
                .checkPriceAmount("₽ 47 000.00");
    }

    @Test
    void articleShouldContainSearchEngineSharesAndGostCitationTest() {
        open(Config.WIKIPEDIA_URL, WikipediaMainPage.class)
                .search("Информационные технологии")

                .checkTitle("Информационные технологии")
                .checkSearchEngineShare("Google — 86,64 %")
                .checkSearchEngineShare("Bing — 7 %")
                .checkSearchEngineShare("Yahoo! — 2,75 %")

                .openPageTools()
                .openCitePage()
                .checkCitationStyle("Стиль по ГОСТ 7.0.5—2008 (библиографическая ссылка)");
    }
}
