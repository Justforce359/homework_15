package com.justforge359.tests;

import com.codeborne.pdftest.PDF;
import com.justforge359.pages.CreditPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditPageTest extends TestBase {

    public static final String TEXTEXCIST = "Кредит на любые цели";
    public static final String TEXTINPDF = "Приложение №2";

    CreditPage creditPage = new CreditPage();

    @Test
    @DisplayName("Проверка cуществования страницы с кредитными предложениями")
    void creditPageExsicstTest() {
        creditPage
                .openPage()
                .checkTextExcist(TEXTEXCIST);
    }

    @Test
    @DisplayName("Проверка скачивания пдф файла")
    void downloadPDFFileTest() throws Exception {
        File pdfFile = creditPage.openPage()
                .downloadPDF();
        PDF pdf = new PDF(pdfFile);
        assertTrue(pdf.text.startsWith(TEXTINPDF));
    }
}
