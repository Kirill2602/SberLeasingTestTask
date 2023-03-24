package ru.sberleasing.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class CarCardInfoPage {
    SelenideElement carCardInfoHeading = $x("//h1[@class='h2']"),
            carCardBlock = $x("//div[@class='car-card__list']");

    @Step("Проверить текст в заголовке страницы")
    public CarCardInfoPage checkCarCardInfoHeadingText(String value) {
        carCardInfoHeading.shouldHave(text(value));
        return this;
    }

    @Step("Проверить текст в заголовке карточки")
    public void checkCarCardBlockHeadingText(String value) {
        carCardBlock.shouldHave(text(value));
    }
}
