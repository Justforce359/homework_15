package com.justforge359.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DepositsPage {
    public DepositsPage openPage() {
        open("deposits");
        return this;
    }

    private SelenideElement
            sectionHeader = $(".bs-header__wrapper"),
            fieldsTerm = $(".fields-term"),
            informationTextAndNumbers = $(".info");


    @Step("Проверить наличие текста {0} на странице")
    public DepositsPage textVisible(String visibleText) {
        sectionHeader.shouldHave(text(visibleText));
        return this;
    }
    @Step("Выбрать опцию {0} на странице")
    public DepositsPage textWithNumber(String numberAndText) {
        fieldsTerm.$(byText(numberAndText)).scrollTo().click();
        return this;
    }
    @Step("Проверить корректность заголовка предложения")
    public DepositsPage informationTextCorrect(String correctText) {
        informationTextAndNumbers.$(byText(correctText)).shouldBe(visible);
        return this;
    }
    @Step("Проверить наличие цифр в блоке текста")
    public DepositsPage informationNumbersCorrect(String correctNumbers) {
        informationTextAndNumbers.$(byText(correctNumbers)).shouldBe(visible);
        return this;
    }
}
