package com.store.demoqa.test;

import com.store.demoqa.BaseTest;
import com.store.demoqa.data.UserParameterResolver;
import com.store.demoqa.model.User;
import com.store.demoqa.pages.ToolsQALoggedOutPage;
import com.store.demoqa.pages.YourAccountPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.open;
import static com.store.demoqa.utils.DefaultData.DEFAULT_LOGIN;
import static com.store.demoqa.utils.DefaultData.DEFAULT_PASS;
import static org.hamcrest.MatcherAssert.assertThat;

//@ExtendWith(UserParameterResolver.class)
public class YourAccountTest extends BaseTest {

    private YourAccountPage yourAccountPage;
    private ToolsQALoggedOutPage toolsQALoggedOutPage;

    @BeforeEach
    void setUp() {
        yourAccountPage = new YourAccountPage();
        toolsQALoggedOutPage = new ToolsQALoggedOutPage();
        open("/");
    }

    @Test
    @DisplayName("Авторизация в систему")
    void verifySuccessfulAuthorization() {
        yourAccountPage.goToYourAccountPage().
                loginAs(DEFAULT_LOGIN, DEFAULT_PASS)
                .logout();
        assertThat("The authorization page is displayed", toolsQALoggedOutPage.isPageLoaded());
    }

    @Test
    @DisplayName("Авторизация не проходит")
    void verifyUnsuccessfulAuthorization(User valueAuthorization) {
        yourAccountPage.goToYourAccountPage().
                noLogin(valueAuthorization);
    }


}
