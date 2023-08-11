package com.justforge359.tests;

import com.codeborne.selenide.Condition;
import com.justforge359.pages.DepositsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DepositsPageTest extends TestBase {

    public static final String TEXTVISIBLE = "Вклады и счета";
    public static final String TEXTWITHNUMBER = "1 год";
    public static final String INFTEXT = "Вклад «Первый»";
    public static final String INFNUMBER = "9,00";
    DepositsPage depositsPage = new DepositsPage();

    @Test
    @DisplayName("Проверка страницы с вкладами и счетами")
    void depositsPageExistTest() {
        depositsPage
                .openPage()
                .textVisible(TEXTVISIBLE);
    }

    @Test
    @DisplayName("Проверка соответствия при выборе другой опции")
    void correctConditionTest() {
        depositsPage
                .openPage()
                .textWithNumber(TEXTWITHNUMBER)
                .informationTextCorrect(INFTEXT)
                .informationNumbersCorrect(INFNUMBER);
    }
}
