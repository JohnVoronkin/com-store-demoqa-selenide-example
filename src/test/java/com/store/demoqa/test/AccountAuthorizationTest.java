package com.store.demoqa.test;

import com.store.demoqa.BaseTest;
import com.store.demoqa.data.UserParameterResolver;
import com.store.demoqa.model.User;
import com.store.demoqa.pages.ToolsQALoggedOutPage;
import com.store.demoqa.pages.YourAccountPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;
import static com.store.demoqa.utils.DefaultData.DEFAULT_LOGIN;
import static com.store.demoqa.utils.DefaultData.DEFAULT_PASS;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountAuthorizationTest extends BaseTest {

    private YourAccountPage yourAccountPage;
    private ToolsQALoggedOutPage toolsQALoggedOutPage;

    @BeforeEach
    void setUp() {
        yourAccountPage = new YourAccountPage();
        toolsQALoggedOutPage = new ToolsQALoggedOutPage();
        open("/");
        yourAccountPage.load();
    }

    @Test
    void verifySuccessfulAuthorization() {
        yourAccountPage.loginAs(DEFAULT_LOGIN, DEFAULT_PASS)
                .logout();
        assertThat("The authorization page is displayed", toolsQALoggedOutPage.isPageLoaded());
    }

    @ParameterizedTest
    @ArgumentsSource(UserParameterResolver.class)
    @Test
    void verifyUnsuccessfulAuthorization(ArrayList<User> users) {
        yourAccountPage.
                noLogin(users);
    }


}
