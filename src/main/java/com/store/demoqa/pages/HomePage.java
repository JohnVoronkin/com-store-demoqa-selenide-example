package com.store.demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.store.demoqa.base.BasePage;
import com.store.demoqa.base.LoadablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.store.demoqa.pages.URLMenu.HOME_PAGE;
import static com.store.demoqa.pages.WarningMessages.INVALID_SEARCH;
import static com.store.demoqa.utils.DefaultData.PRODUCT_IPHONE_4S_32;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

/**
 * This page is a page object example Home Page
 */
public class HomePage extends BasePage implements LoadablePage {

    private final ElementsCollection menuMain = $$(byXpath("//*[@id='menu-main-menu']/li/a"));

    private final SelenideElement logo = $(byXpath("//*[@id='logo']")),
            contentSearch = $(byXpath("//div[@id='content']/p")),
            searchProduct = $(byXpath("//input[@class='search']"));

    /**
     * Поиск товара по имени
     *
     * @param productName искомое имя продукта
     * @return HomePage
     */
    public HomePage checkTheProductSearch(String productName) {
        inputStringField(searchProduct, productName);
        searchProduct.pressEnter();
        try {
            // Проверяем результат (сообщение) о некорректном поиске
            if (isElementPresent(byXpath(String.valueOf(contentSearch))))
                contentSearch.shouldHave(text(INVALID_SEARCH.getWarningMessages()));
        } catch (NoSuchElementException | ElementNotFound ex) {
            // Проверяем результат корректного поиска
            $(By.xpath("//div[contains(@id,'grid_view_products_page_container')]//h2/a[contains(text(),'"
                    + PRODUCT_IPHONE_4S_32 + "')]"))
                    .waitUntil(visible, 10000);
        }
        return this;
    }

    @Override
    public boolean isPageLoaded() {
        try {
            menuMain.shouldBe(size(4));
            logo.shouldBe(Condition.visible);
            return true;
        } catch (NoSuchElementException | ElementNotFound ex) {
            ex.printStackTrace();
            fail("The required items on the page are not displayed");
            return false;
        }
    }

    @Override
    public void load() {
        open(HOME_PAGE.getMenuURL());
        assertThat("Проверяем загрузку домашней стр.", isPageLoaded());
    }

}
