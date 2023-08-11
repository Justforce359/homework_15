package com.justforge359.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainPage {
    private SelenideElement

            footerBar = $(".FooterInfo_footer-info-wrapper__Yi_3T"),
            searchIcon = $(".HeaderSearch_search-icon__Y1fgh"),
            searchInput = $(".open-ui-search-input"),
            resoultsContainer = $(".search-results-container"),
            languageButton = $(".HeaderTopBlock_language-button__8d22Q"),
            hederBar = $(".header"),
            hederAboutUs = $(".HeaderTopBlock_additional-tabs-wrapper__8Ebw3"),
            hederTab = $(".AdditionalTabs_additional-tab__ulWwH"),
            bankInfo = $(".about-bank__info");

    @Step("Открываем главную страницу")
    public MainPage openMainPage() {
        open("https://www.open.ru/");
        return this;
    }

    @Step("Проверяем отображение текста")
    public MainPage textShouldBeVisible() {
        footerBar.shouldHave(text("ФК Открытие"));
        return this;
    }

    @Step("Нажимаем на иконку поиска")
    public MainPage searchClick() {
        searchIcon.click();
        return this;
    }

    @Step("Ввести значение: {0} в инпут поиска и выполнить поиск")
    public MainPage searchPlaceHolderClick(String searchValue) {
        searchInput.setValue(searchValue);
        searchInput.pressEnter();
        return this;
    }

    @Step("Проверить текст {0} в результатах поиска")
    public MainPage checkSearchResultsPageText(String expectedText) {
        resoultsContainer.$(byText(expectedText)).shouldBe(visible);
        return this;
    }

    @Step("Найти и нажать на кнопку переключения языка")
    public MainPage searchLanguageButton(String enText) {
        languageButton.$(byText(enText)).click();
        return this;
    }

    @Step("Проверить текст {0} на загруженной странице")
    public MainPage checkHeaderText(String headerText) {
        hederBar.$(byText(headerText)).shouldBe(visible);
        return this;
    }

    @Step("Найти и нажать на название подраздела")
    public MainPage clickAdditionalTab() {
        hederAboutUs.click();
        return this;
    }

    @Step("Найти раздел {0} и кликнуть на него")
    public MainPage clickTabWithCorrectName(String elementtText) {
        hederTab.$(byText(elementtText)).click();
        return this;
    }

    @Step("Проверить наличие текста {0}")
    public MainPage checkCorrectText(String correctText) {
        bankInfo.shouldHave(text(correctText)).shouldBe(visible);
        return this;
    }
}
