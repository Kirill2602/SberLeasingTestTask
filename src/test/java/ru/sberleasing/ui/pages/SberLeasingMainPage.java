package ru.sberleasing.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SberLeasingMainPage {
    SelenideElement sberLeasingLogo = $x("//a[@aria-label='АО «Сбербанк Лизинг»']"),
            leasingItem = $x("//a[contains(@class,'header-menu__link') and text()='Предметы лизинга']"),
            passengerCarLink = $x("//a[@class='header-menu__link' and @href='/leasing/leasing-legkovykh-avtomobiley/']");

    @Step("Проверить видимость логотипа на странице")
    public SberLeasingMainPage checkVisibilityOfLogo() {
        sberLeasingLogo.shouldBe(visible);
        return this;
    }

    @Step("Навести курсор на раздел меню 'Предметы лизинга' и выбрать в выпадающем списке 'Легковые автомобили'")
    public PassengerCarLeasingPage clickOnPassengerCarLink() {
        leasingItem.parent().hover();
        passengerCarLink.click();
        return new PassengerCarLeasingPage();
    }
}
