package com.justforge359.helpers;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class DriverSettings {
    public static void configure() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.baseUrl = System.getProperty("baseUrl", "https://www.open.ru/");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.remote = System.getProperty("remoteDriverUrl","https://user1:1234@selenoid.autotests.cloud/wd/hub/");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
        Configuration.pageLoadTimeout=3000000;
        Configuration.timeout=3000000;


        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--dns-prefetch-disable");
        chromeOptions.addArguments("disable-browser-side-navigation");
        chromeOptions.addArguments("disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--single-process");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("enable-automation");
        chromeOptions.addArguments("--disable-browser-side-navigation");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        chromeOptions.addArguments("enable-features=NetworkServiceInProcess");
    }
}
