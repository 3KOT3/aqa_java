package ru.bulgakov.qa;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.bidi.Command;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Map;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Lesson1 {

    @Test
    void studyPriceShouldBe47000Test() {
        Configuration.browser = "chrome";               // выбор браузера
        Configuration.pageLoadTimeout = 20000;          // таймаут загрузки страницы
        Configuration.timeout = 20000;                  // таймаут загрузки элементов
        Configuration.browserSize = "1920x1080";        // размер браузера

        open("https://ya.ru/");
        $("textarea.search3__input").setValue("bulgakov qa").pressEnter();
        System.out.println(1);


        if ($(".DistributionButtonClose").exists()) {
            $(".DistributionButtonClose").shouldBe(interactable, Duration.ofSeconds(4)).click();
        }

        $(byText("ivanbulgakovqa.ru")).click();
        switchTo().window(1);
        $$(".t-menu__list li").last().click();
        $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a/div/span").shouldHave(text("Хочу вкатиться в QA")).click();
        $(byText("Бегу оплачивать")).click();

        switchTo().window(2);
        $("span.ant-select-selection-wrap").click();
        $(byText("RUB")).click();

        $(".styles-module-scss-module__kWKzya__price").shouldHave(text("₽ 47 000"));
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

        open("https://ru.wikipedia.org/");
        $$(".cdx-text-input__input").first().setValue("Информационные технологии");
        $$(".cdx-button--weight-normal").get(0).click();
        $(".mw-normal-catlinks ul li a").shouldHave(text("Информационные технологии"));

        $$("li[id^='mwA']").findBy(text("Google")).shouldHave(text("86,64 %"));
        $$("li[id^='mwA']").findBy(text("Bing")).shouldHave(text("7 %"));
        $$("li[id^='mwA']").findBy(text("Yahoo!")).shouldHave(text("2,75 %"));

        $("#vector-page-tools-dropdown-checkbox").click();
        $("#t-cite").click();
        $$(".mw-heading3").first().shouldHave(text("Стиль по ГОСТ 7.0.5—2008 (библиографическая ссылка)"));

    }
}

