package ru.bulgakov.webshop;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void before() {
        Configuration.browserSize = "1980x1020";
    }

    @AfterEach
    void closeDriver() {
        closeWebDriver();
    }
}
