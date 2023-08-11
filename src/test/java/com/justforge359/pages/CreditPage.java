package com.justforge359.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.files.FileFilter;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.io.File;
import java.io.FileInputStream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class CreditPage {

    public CreditPage openPage() {
        open("credits/cash");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    private SelenideElement
            sectionPrograms = $(".section--programs");

    @Step("Проверить наличие текста {0} на странице")
    public CreditPage checkTextExcist(String shouldText) {
        sectionPrograms.shouldHave(text(shouldText)).shouldBe(visible);
        return this;
    }

    @Step("Скачать pdf-файл")
    public File downloadPDF() throws Exception {
        File file = $("a[href*='IncomeCertificate_Credit.pdf']").download(new FileFilter() {
            @Override
            public boolean match(File file) {
                return file.getName().contains("IncomeCertificate");
            }

            @Override
            public String description() {
                return "pdf";
            }
        });

        Allure.addAttachment("pdf", new FileInputStream(file));
        return file;
    }
}