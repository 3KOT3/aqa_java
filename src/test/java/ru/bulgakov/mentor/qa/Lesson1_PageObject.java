package ru.bulgakov.mentor.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.bulgakov.mentor.pages.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static ru.bulgakov.mentor.config.Config.*;

public class Lesson1_PageObject {

    @BeforeAll
    static void beforeAll() {
        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 20000;
        Configuration.browserSize = "1920x1080";

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

        open(WEBSITE_LINK, WikipediaWelcomPage.class)
                .insertInput("Информационные технологии")
                .buttonSearchClick()

                .checkTitle("Информационные технологии")
                .verificationInformation("Google", "86,64 %")
                .verificationInformation("Bing", "7 %")
                .verificationInformation("Yahoo!", "2,75 %")

                .ToolsOfThePage()
                .selectQuoteTool()
                .checkingGostPageQoute("Стиль по ГОСТ 7.0.5—2008 (библиографическая ссылка)");
    }
}


