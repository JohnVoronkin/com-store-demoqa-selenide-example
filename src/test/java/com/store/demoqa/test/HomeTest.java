package com.store.demoqa.test;

import com.store.demoqa.BaseTest;
import com.store.demoqa.pages.HomePage;
import com.store.demoqa.rules.ScreenShotOnFailRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;


import static com.codeborne.selenide.Selenide.open;
import static com.store.demoqa.pages.WarningMessages.INVALID_SEARCH;
import static io.qala.datagen.RandomShortApi.alphanumeric;
import static io.qala.datagen.RandomValue.length;
import static io.qala.datagen.StringModifier.Impls.specialSymbol;

@RunWith(DataProviderRunner.class)
public class HomeTest extends BaseTest {

    private HomePage homePage;

    @DataProvider
    public static Object[][] bordersOfFieldValuesSearch() {
        // @formatter:off
        return new Object[][]{
                {length(1).with(specialSymbol()).english(), INVALID_SEARCH.getWarningMessages()},
                {alphanumeric(2, 19), INVALID_SEARCH.getWarningMessages()},
                {length(20).with(specialSymbol()).english(), INVALID_SEARCH.getWarningMessages()},
        };
        // @formatter:on
    }

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void setUp() {
        homePage = new HomePage();
        open("/");
    }

    @Test
    public void verifyMainMenu() {
        homePage.verifyMainMenuElements();
    }

    @Test
    @UseDataProvider("bordersOfFieldValuesSearch")
    public void checkTheInvalidSearch(String valueSearch, String errorMessages) {
        homePage.checkTheProductSearch(valueSearch, errorMessages);
    }

}
