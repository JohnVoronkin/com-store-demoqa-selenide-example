package ru.selenide.gmail.base;


import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertEquals;

public abstract class BasePage {

    public abstract boolean isPageLoaded();

    /**
     * Реализация переход по разделам системы напрямую по точному URL
     *
     * @param URL передаваемая ссылка для навигации
     */
    public static void openSectionOnURL(String URL) {
        open(URL);
        assertEquals(baseUrl + URL, getWebDriver().getCurrentUrl());

    }

}
