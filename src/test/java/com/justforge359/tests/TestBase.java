package com.justforge359.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.open.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

}
