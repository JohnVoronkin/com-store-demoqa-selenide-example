package com.store.demoqa.test;

import com.store.demoqa.BaseTest;
import com.store.demoqa.pages.HomePage;
import com.store.demoqa.pages.YourAccountPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.store.demoqa.utils.DefaultData.*;

/**
 * Add Cart test
 */
public class AddCartTest extends BaseTest {

    private YourAccountPage yourAccountPage;
    private HomePage homePage;

    @BeforeEach
    void setUp() {
        yourAccountPage = new YourAccountPage();
        homePage = new HomePage();
        open("/");
        yourAccountPage.load();
    }

    @Test
    void verifyAddCart() {
        yourAccountPage.loginAs(DEFAULT_LOGIN, DEFAULT_PASS);
        homePage.checkTheProductSearch(PRODUCT_IPHONE_4S_32);
        // TODO проверка - добавление товара в корзину
    }


}
