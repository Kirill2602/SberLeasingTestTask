package ru.sberleasing.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchPage {
    SelenideElement searchField = $x(" //*[@name='q']");

    @Step("Открыть страницу поиска")
    public GoogleSearchPage openPage() {
        open("https://www.google.com");
        return this;
    }

    @Step("Ввести текст в поле поиска и нажать кнопку Enter")
    public SearchResultPage setValueAndPressEnter(String value) {
        searchField.setValue(value).pressEnter();
        return new SearchResultPage();
    }
}
