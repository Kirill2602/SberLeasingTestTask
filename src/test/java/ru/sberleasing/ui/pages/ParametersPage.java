package ru.sberleasing.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ParametersPage {
    SelenideElement heading = $x("//h2[text()='Подобрать авто по параметрам']"),
            cityFilterParam = $x("//label[@id='filter-city']"),
            cityFilterItem = $x("//label[text()='Москва']"),
            markFilterParam = $x("//label[@id='filter-mark']"),
            markFilterItem = $x("//label[text()='Chery']"),
            modelFilterParam = $x("//label[@id='filter-model']"),
            modelFilterItem = $x("//label[text()='Tiggo 4']"),
            onlyWithDiscountCheckbox = $x("//label[text()='Только авто со скидкой']"),
            enginePowerRange = $x("//div[@aria-label='slider between 113 and 147']//div[contains(@class,'el-slider__button-wrapper')]"),
            carDriveCheckbox = $x("//label[text()='передний']"),
            gearShiftBoxCheckbox = $x("//label[text()='автомат']"),
            bodyTypeCheckbox = $x("//label[@title='кроссовер']"),
            fuelTypeCheckbox = $x("//label[text()='бензин']"),
            colorFilter = $x("//label[@aria-label='Цвет']"),
            colorFilterItem = $x("//label[text()='серый']"),
            showAllOffersButton = $x("//a[text()=' Показать все предложения ']"),
            bodyTypeBlockHeading = $x("//div[text()=' Тип кузова ']"),
            closeCookieModalButton = $x("//div[contains(@class, 'cookie-warning__group mb-30 p-30 shadow rounded bg-white d-grid align-items-center')]/button");
    ElementsCollection engineCapacityRange = $$x("//div[@aria-label='slider between 1498 and 1971']//div[contains(@class,'el-slider__button-wrapper')]");

    @Step("Проверить видимость заголовка на старице")
    public ParametersPage checkVisibilityOfHeadingText() {
        heading.shouldBe(visible);
        return this;
    }

    @Step("Нажать на чекбокс 'Только со скидкой'")
    public ParametersPage clickOnlyWithDiscountCheckbox() {
        onlyWithDiscountCheckbox.click();
        return this;
    }

    @Step("Выбрать фильтр по городу")
    public ParametersPage chooseCity() {
        cityFilterParam.click();
        cityFilterItem.click();
        cityFilterParam.click();
        return this;
    }

    @Step("Выбрать фильтр по марке")
    public ParametersPage chooseMark() {
        markFilterParam.click();
        markFilterItem.click();
        markFilterParam.click();
        return this;
    }

    @Step("Выбрать фильтр по модели")
    public ParametersPage chooseModel() {
        modelFilterParam.click();
        modelFilterItem.click();
        markFilterParam.click();
        return this;
    }

    @Step("Передвинуть ползунок 'Мощность двигателя' в большую сторону")
    public ParametersPage moveEnginePowerRange() {
        for (int i = 0; i < 7; i++) {
            enginePowerRange.sendKeys(Keys.ARROW_RIGHT);
        }
        return this;
    }

    @Step("Передвинуть ползунок 'Объем двигателя' в меньшую сторону")
    public ParametersPage moveEngineCapacityRange() {
        for (int i = 0; i < 10; i++) {
            engineCapacityRange.get(1).sendKeys(Keys.ARROW_LEFT);
        }
        return this;
    }

    @Step("Нажать на чекбокс выбора 'Привода'")
    public ParametersPage clickCarDriveCheckbox() {
        carDriveCheckbox.click();
        return this;
    }

    @Step("Нажать на чекбокс выбора 'Коробки передач'")
    public ParametersPage clickGearShiftBoxCheckbox() {
        gearShiftBoxCheckbox.click();
        return this;
    }

    @Step("Нажать на чекбокс выбора 'Типа кузова'")
    public ParametersPage clickBodyTypeCheckbox() {
        closeCookieModalButton.click();
        bodyTypeBlockHeading.scrollTo();
        bodyTypeCheckbox.click();
        return this;
    }

    @Step("Нажать на чекбокс выбора 'Типа топлива'")
    public ParametersPage clickFuelTypeCheckbox() {
        fuelTypeCheckbox.click();
        return this;
    }

    @Step("Нажать на кнопку 'Показать все предложения'")
    public FilteredResultPage clickShowAllOffersButton() {
        showAllOffersButton.scrollTo().click();
        return new FilteredResultPage();
    }

    @Step("Выбрать фильтр по цвету")
    public ParametersPage chooseColor() {
        colorFilter.click();
        colorFilterItem.click();
        colorFilter.click();
        return this;
    }
}
