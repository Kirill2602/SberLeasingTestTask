package ru.sberleasing.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class FilteredResultPage {
    SelenideElement carCardHeading = $x("//div[text()=' Tiggo 4 ']"),
            showOffersButton = $x("//div[contains(text(), ' Смотреть предложения: ')]");

    @Step("Получить название марки автомобиля")
    public String getCarCardHeadingText() {
        return carCardHeading.text();
    }

    @Step("Нажать на кнопку 'Показать все предложения' ")
    public CarCardInfoPage clickOnShowOffersButton() {
        showOffersButton.click();
        return new CarCardInfoPage();
    }
}
