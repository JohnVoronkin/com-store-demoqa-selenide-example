package com.store.demoqa.test;

import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import com.store.demoqa.BaseTest;
import com.store.demoqa.pages.HomePage;
import com.store.demoqa.pages.YourAccountPage;
import com.store.demoqa.utils.ScreenShotOnFailListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.store.demoqa.utils.DefaultData.*;

/**
 * Add Cart test
 */
@Listeners({ScreenShotOnFailListener.class, TextReport.class})
@Report
public class AddCartTest extends BaseTest {

    private YourAccountPage yourAccountPage;
    private HomePage homePage;

    @BeforeMethod
    void setUp() {
        yourAccountPage = new YourAccountPage();
        homePage = new HomePage();
        open("/");
    }

    @Test
    void verifyAddCart() {
        yourAccountPage.goToYourAccountPage().
                loginAs(DEFAULT_LOGIN, DEFAULT_PASS);
        homePage.checkTheProductSearch(PRODUCT_IPHONE_4S_32);
        // TODO проверка - добавление товара в корзину
    }


}
