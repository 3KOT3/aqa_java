package ru.bulgakov.mentor.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Lesson1 {

    @Test
    void mentoringPriceShutBe47000Test() {
        Configuration.holdBrowserOpen = true;                       // держать бразуер всегда открытым после заверешния теста

        open("https://ya.ru/");                    // открыть сайт
        $("#text").setValue("bulgakov qa").pressEnter();  // ищем по локатору id, вводим текст и нажимаем enter
        $(".DistributionButtonClose").click();            // ищем по классу . и кликаем
        $(byText("ivanbulgakovqa.ru")).click();          // ищем по тексту и кликаем
        sleep(7000);                                     // спим 6 сек для прогрузки элементов на странице

        switchTo().window(1);                                 // переключаемся на вкладку по индексу
        $$(".t-menu__list li").last().click();            // кликаем на последний элемент в коллекции
        $x("/html/body/div[1]/div[42]/div/div/div[32]/div").click(); // поиск по пути и клик (в крайних случаях)
        $(byText("Бегу оплачивать")).click();             // ищем по тексту и кликаем
        sleep(7000);                                      // спим 6 сек для прогрузки элементов на странице

        switchTo().window(2);                                  // переключаемся на вкладку по индексу
        $(".styles-module-scss-module__kWKzya__prices").shouldHave(text("₽ 47 000.00")); // ищем по классу и далее условие (элемент должен иметь текст)
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
        $$(".cdx-text-input__input").get(0).setValue("Информационные технологии");
        $$(".cdx-button--weight-normal").get(0).click();
        $("#mwAU8").shouldHave(text("Google — 86,64 %"));
        $("#mwAVE").shouldHave(text("Bing — 7 %;"));
        $("#mwAVM").shouldHave(text("Yahoo! — 2,75 %"));


        $("#vector-page-tools-dropdown-checkbox").click();
        $("#t-cite").click();
        $$(".mw-heading3").get(0).shouldHave(text("Стиль по ГОСТ 7.0.5—2008 (библиографическая ссылка)"));

    }
}

