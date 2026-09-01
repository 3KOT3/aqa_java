package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WelcomPage {

    private final ElementsCollection amountMentors = $$(".t-menu__list li");
    private final SelenideElement buttonYesoffer = $x("/html/body/div[1]/div[42]/div/div/div[32]/div");

    public WelcomPage clickPrice() {
        return this;
    }

    public WelcomPage customSlleep(int milliseconds) {
        sleep(milliseconds);
        return this;
    }

    public WelcomPage customSwitchToWindow(int index) {
        switchTo().window(index);
        return this;
    }

    public WelcomPage selectMenuAmountMentors() {
        amountMentors.last().click();
        return this;
    }

    public WelcomPage detailedСonditionsAndAmountMentors() {
        buttonYesoffer.click();
        return this;
    }

    public WelcomPage searchTextPage(String text) {
        $(byText(text)).click();
        return this;
    }
}
