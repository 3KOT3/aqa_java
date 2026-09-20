package ru.bulgakov.webshop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.bulgakov.webshop.util.Attachments;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    @BeforeAll
    static void before() {
        Configuration.browserSize = "1980x1020";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void closeDriver() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        Attachments.takeScreenshot();
        Attachments.getPageSource();
        Attachments.getBrowserConsoleLogs();
    }
}
