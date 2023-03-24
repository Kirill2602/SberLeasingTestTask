package ru.sberleasing.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassengerCarLeasingPage {
    SelenideElement heading = $x("//h1"),
            autoItem = $x("//div[text()='Jeep']"),
            selectByParamsButton = $x("//div[@class='text-center']");

    @Step("Проверить текст заголовка")
    public PassengerCarLeasingPage checkHeadingText(String value) {
        assertEquals(value, heading.text());
        return this;
    }

    @Step("Нажать кнопку 'Выбрать по параметрам'")
    public ParametersPage clickOnSelectByParamsButton() {
        autoItem.scrollTo();
        selectByParamsButton.click();
        return new ParametersPage();
    }
}
