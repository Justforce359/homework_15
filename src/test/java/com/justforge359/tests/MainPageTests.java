package com.justforge359.tests;

import com.justforge359.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainPageTests extends TestBase {

    public static final String INPUTTEXT = "ипотека";
    public static final String CHECKTEXT = "Дальневосточная ипотека";
    public static final String CHOICELANGUAGES = "EN";
    public static final String CHECKENTEXT = "About The Bank";
    public static final String CORRECTTABNAME = "Общая информация";
    public static final String CHECKTEXTABOUTBANK = "Банк «Открытие» входит";

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка загрузки главной страницы")
    void mainPageExistTest() {
        mainPage
                .openMainPage()
                .textShouldBeVisible();
    }

    @Test
    @DisplayName("Поиск информации о продуктах или услугах")
    void searchInfoTest() {
        mainPage
                .openMainPage()
                .searchClick()
                .searchPlaceHolderClick(INPUTTEXT)
                .checkSearchResultsPageText(CHECKTEXT);
    }

    @Test
    @DisplayName("Проверка возможности переключения языка")
    void choiceLanguageTest() {
        mainPage
                .openMainPage()
                .searchLanguageButton(CHOICELANGUAGES)
                .checkHeaderText(CHECKENTEXT);

    }

    @Test
    @DisplayName("Проверка раздела Общая информация")
    void aboutUsTest() {
        mainPage
                .openMainPage()
                .clickAdditionalTab()
                .clickTabWithCorrectName(CORRECTTABNAME)
                .checkCorrectText(CHECKTEXTABOUTBANK);

    }
}
