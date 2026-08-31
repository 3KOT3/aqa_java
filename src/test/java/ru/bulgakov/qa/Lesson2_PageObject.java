package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import ru.bulgakov.pages.PaymentPage;
import ru.bulgakov.pages.WikipediaSearch;
import ru.bulgakov.pages.YandexSearchPage;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class Lesson2_PageObject {

    @Test
    void mentoringPriceShutBe47000Test() {
        PaymentPage paymentPage = new PaymentPage();

        open("https://ya.ru/", YandexSearchPage.class)

                .search("bulgakov qa")
                .closeDefaultBrowserSelectWindow()
                .openLink("ivanbulgakovqa.ru")

                .customSlleep(7000)   // в отдельный класс helper, но пока так
                .customSwitchToWindow(1)   // в отдельный класс helper, но пока так

                .selectMenuAmountMentors()
                .detailedСonditionsAndAmountMentors()
                .searchTextPage("Бегу оплачивать")

                .customSlleep(7000)
                .customSwitchToWindow(2)

                .searchTextPage("₽ 47 000.00");
    }


    @Test
    void WikipediaSearcherAndValidator() {

        open("https://ru.wikipedia.org/", WikipediaSearch.class)

                .search("Информационные технологии")
                .clickButtonSearch()

                .dataValidatorGoogle("Google — 86,64 %")
                .dataValidatorBing("Bing — 7 %;")
                .dataValidatorYahoo("Yahoo! — 2,75 %")

                .clickInstruments()
                .selectInstrumentsQuoteTool()
                .stilesGostBiographyLink("Стиль по ГОСТ 7.0.5—2008 (библиографическая ссылка)");
    }
}

