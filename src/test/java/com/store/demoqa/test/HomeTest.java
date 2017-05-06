package com.store.demoqa.test;

import com.store.demoqa.BaseTest;
import com.store.demoqa.data.DataValueParameterForSearch;
import com.store.demoqa.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomeTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void setUp() {
        homePage = new HomePage();
        open("/");
    }

    @Test
    void verifyMainMenu() {
        assertThat("Проверяем загрузку домашней стр.", homePage.isPageLoaded());
    }


    @ParameterizedTest
    @ArgumentsSource(DataValueParameterForSearch.class)
    @Test
    void checkSearch(String valueSearch) {
        homePage.checkTheProductSearch(valueSearch);
    }




}
