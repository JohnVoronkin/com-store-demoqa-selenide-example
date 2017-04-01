package com.store.demoqa.test;


import com.store.demoqa.BaseTest;
import com.store.demoqa.model.UserAccount;
import com.store.demoqa.pages.YourAccountPage;
import com.store.demoqa.rules.ScreenShotOnFailRule;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.store.demoqa.utils.DefaultData.DEFAULT_LOGIN;
import static com.store.demoqa.utils.DefaultData.DEFAULT_PASS;

@RunWith(DataProviderRunner.class)
public class YourAccountTest extends BaseTest {

    private YourAccountPage yourAccountPage;


    @DataProvider
    public static Object[][] combinationsOfNonValidAuthorization() {
        // @formatter:off
        return new Object[][]{
                {new UserAccount().randomValue()},
                {new UserAccount().randomValue()},
                {new UserAccount().randomValue()},
                {new UserAccount().randomValue()},
                {new UserAccount().randomValue()},

        };
        // @formatter:on
    }

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void setUp() {
        yourAccountPage = new YourAccountPage();
    }

    @Test
    public void verifySuccessfulAuthorization() {
        yourAccountPage.goToYourAccountPage().
                loginAs(DEFAULT_LOGIN, DEFAULT_PASS);
    }

    @Test
    @UseDataProvider("combinationsOfNonValidAuthorization")
    public void verifyUnsuccessfulAuthorization(UserAccount userAuthorization) {
        yourAccountPage.goToYourAccountPage().
                noLogin(userAuthorization);
    }


}
