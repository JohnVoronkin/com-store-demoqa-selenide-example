package com.store.demoqa.test;

import com.store.demoqa.BaseTest;
import com.store.demoqa.data.UserParameterResolver;
import com.store.demoqa.model.User;
import com.store.demoqa.pages.YourAccountPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.store.demoqa.utils.DefaultData.DEFAULT_LOGIN;
import static com.store.demoqa.utils.DefaultData.DEFAULT_PASS;

@ExtendWith(UserParameterResolver.class)
public class YourAccountTest extends BaseTest {

    private YourAccountPage yourAccountPage;

    @BeforeEach
    void setUp() {
        yourAccountPage = new YourAccountPage();
    }

    @Test
    void verifySuccessfulAuthorization() {
        yourAccountPage.goToYourAccountPage().
                loginAs(DEFAULT_LOGIN, DEFAULT_PASS);
    }

    @Test
    void verifyUnsuccessfulAuthorization(User valueAuthorization) {
        yourAccountPage.goToYourAccountPage().
                noLogin(valueAuthorization);
    }


}
