package ru.bulgakov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import net.bytebuddy.asm.Advice;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WelcomPage {

    private final SelenideElement amountMentors =  $("a.t-menu__link-item[href='#cost']");
    private final SelenideElement buttonYesoffer = $x("/html/body/div[1]/div[42]/div/div/div[32]/div");


    public WelcomPage clickPrice() {
        return this;
    }

    public WelcomPage selectMenuAmountMentors() {
        amountMentors.click();
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

    public <T> T switchToWindow(int index, Class<T> pageClass) {
        switchTo().window(index);
        return page(pageClass);
    }

    public WelcomPage buttonLinkPagePayment(String text) {
        $(byText(text)).click();
        return this;
    }
}


