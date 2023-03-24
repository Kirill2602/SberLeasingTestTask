package ru.sberleasing.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.sberleasing.ui.pages.GoogleSearchPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.google.com";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void addLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new GoogleSearchPage().openPage();
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
