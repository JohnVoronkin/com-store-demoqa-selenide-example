package com.store.demoqa.test;

import com.store.demoqa.BaseTest;
import com.store.demoqa.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static com.store.demoqa.pages.WarningMessages.INVALID_SEARCH;
import static io.qala.datagen.RandomShortApi.numeric;
import static io.qala.datagen.RandomShortApi.unicode;
import static io.qala.datagen.RandomValue.length;
import static io.qala.datagen.StringModifier.Impls.prefix;
import static io.qala.datagen.StringModifier.Impls.specialSymbol;
import static java.util.Arrays.asList;


public class HomeTest extends BaseTest {

    private HomePage homePage;


    @BeforeEach
    void setUp() {
        homePage = new HomePage();
        open("/");
    }

    @Test
    void verifyMainMenu() {
        homePage.verifyMainMenuElements();
    }

    @ParameterizedTest
    @MethodSource(names = "loginAndPasswordProvider")
    void checkTheInvalidSearch(String valueSearch, String errorMessage) {
        homePage.checkTheProductSearch(valueSearch)
                .verifyInvalidResultSearch(errorMessage);
    }

    static Iterable<String> loginAndPasswordProvider() {
        return asList(length(10).with(prefix("Search")).numeric(), INVALID_SEARCH.getWarningMessages(),
                length(20).with(specialSymbol()).english(), INVALID_SEARCH.getWarningMessages(),
                unicode(5, 10), INVALID_SEARCH.getWarningMessages(),
                numeric(5, 19), INVALID_SEARCH.getWarningMessages())
                ;
    }


}
