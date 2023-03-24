package ru.sberleasing.ui.tests;

import org.junit.jupiter.api.Test;
import ru.sberleasing.ui.TestBase;
import ru.sberleasing.ui.pages.FilteredResultPage;
import ru.sberleasing.ui.pages.GoogleSearchPage;

public class UITests extends TestBase {
    String carCardHeadingText;
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    FilteredResultPage filteredResultPage = new FilteredResultPage();

    @Test
    void parameterFilterTest() {
        googleSearchPage
                .setValueAndPressEnter("СберЛизинг")
                .clickSberLeasingLink()
                .checkVisibilityOfLogo()
                .clickOnPassengerCarLink()
                .checkHeadingText("Условия лизинга легковых автомобилей")
                .clickOnSelectByParamsButton()
                .checkVisibilityOfHeadingText()
                .clickOnlyWithDiscountCheckbox()
                .chooseModel()
                .chooseCity()
                .chooseMark()
                .moveEnginePowerRange()
                .clickCarDriveCheckbox()
                .clickGearShiftBoxCheckbox()
                .clickBodyTypeCheckbox()
                .clickFuelTypeCheckbox()
                .moveEngineCapacityRange()
                .chooseColor()
                .clickShowAllOffersButton();
        carCardHeadingText = filteredResultPage.getCarCardHeadingText();
        filteredResultPage
                .clickOnShowOffersButton()
                .checkCarCardInfoHeadingText(carCardHeadingText)
                .checkCarCardBlockHeadingText(carCardHeadingText);
    }
}
