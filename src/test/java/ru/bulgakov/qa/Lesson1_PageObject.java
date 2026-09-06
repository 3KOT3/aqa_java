package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import ru.bulgakov.pages.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class Lesson1_PageObject {

    @Test
    void studyPriceShouldBe47000Test() {
        Configuration.browser = "chrome";               // выбор браузера
        Configuration.pageLoadTimeout = 20000;          // таймаут загрузки страницы
        Configuration.timeout = 20000;                  // таймаут загрузки элементов
        Configuration.browserSize = "1920x1080";        // размер браузера

        open("https://ya.ru/", YandexSearchPage.class)
                .search("bulgakov qa")
                .closeDefaultBrowserSelectWindow()
                .openLink("ivanbulgakovqa.ru")

                .switchToWindow(1, WelcomPage.class)
                .selectMenuAmountMentors()
                .detailedСonditionsAndAmountMentors()
                .buttonLinkPagePayment("Бегу оплачивать")
                .switchToWindow(2, PaymentPage.class)

                .selectPaymentCurrency()
                .selectCurrency("RUB")
                .validatorAmountPage("₽ 47 000");
    }

         /*
     1. Перейти на сайт wikipedia
     2. Найти статью по информационным технологиям
     3. Найти и проверить информацию об распределинии в процентном соотношении поисковых систем Google — 86,64 %,Bing — 7 %, Yahoo! — 2,75 %
     4. Перейти в элементы статьи и выбрать "Цитировать страницу"
     9. Проверить что гост = "Стиль по ГОСТ 7.0.5—2008 (библиографическая ссылка)"
     */

    @Test
    void WikipediaSearcherAndValidator() {

        open("https://ru.wikipedia.org/", WikipediaWelcomPage.class)
                .insertInput("Информационные технологии")
                .buttonSearchClick()

                .ArticlePage("Информационные технологии")

                .verificationInformation("Google", "86,64 %")
                .verificationInformation("Bing", "7 %")
                .verificationInformation("Yahoo!", "2,75 %")

                .ToolsOfThePage()
                .selectQuoteTool()
                .сheckingGostPageQoute("Стиль по ГОСТ 7.0.5—2008 (библиографическая ссылка)");
    }
}


