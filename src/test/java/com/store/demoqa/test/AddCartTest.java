package com.store.demoqa.test;

import com.store.demoqa.BaseTest;
import com.store.demoqa.pages.HomePage;
import com.store.demoqa.pages.YourAccountPage;
import com.store.demoqa.rules.ScreenShotOnFailRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.store.demoqa.utils.DefaultData.DEFAULT_LOGIN;
import static com.store.demoqa.utils.DefaultData.DEFAULT_PASS;
import static com.store.demoqa.utils.DefaultData.PRODUCT_IPHONE_4S_32;

/**
 * Add Cart test
 */
public class AddCartTest extends BaseTest {

    private YourAccountPage yourAccountPage;
    private HomePage homePage;

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void setUp() {
        yourAccountPage = new YourAccountPage();
        homePage = new HomePage();
    }

    @Test
    public void verifyAddCart() {
        yourAccountPage.goToYourAccountPage().
                loginAs(DEFAULT_LOGIN, DEFAULT_PASS);
        homePage.checkTheProductSearch(PRODUCT_IPHONE_4S_32)
                .verifyValidResultSearch(PRODUCT_IPHONE_4S_32);

        // TODO проверка - добавление товара в корзину
    }


}
