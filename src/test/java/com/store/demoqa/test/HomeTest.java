package com.store.demoqa.test;

import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import com.store.demoqa.BaseTest;
import com.store.demoqa.data.DataValueForSearch;
import com.store.demoqa.pages.HomePage;
import com.store.demoqa.utils.ScreenShotOnFailListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Listeners({ScreenShotOnFailListener.class, TextReport.class})
@Report
public class HomeTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    void setUp() {
        homePage = new HomePage();
        open("/");
    }

    @Test
    void verifyMainMenu() {
        homePage.verifyMainMenuElements();
    }


    @Test(dataProvider = "dataForSearch", dataProviderClass = DataValueForSearch.class)
    void checkSearch(String valueSearch) {
        homePage.checkTheProductSearch(valueSearch);
    }


}
