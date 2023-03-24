package ru.sberleasing.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SearchResultPage {
    SelenideElement sberLeasingLink = $x("//a[@href='https://www.sberleasing.ru/']");

    @Step("Перейти по ссылке на сайт СберЛизинга")
    public SberLeasingMainPage clickSberLeasingLink() {
        sberLeasingLink.click();
        return new SberLeasingMainPage();
    }
}
