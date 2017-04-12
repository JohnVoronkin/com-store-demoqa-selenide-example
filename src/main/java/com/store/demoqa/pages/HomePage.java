package com.store.demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.store.demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

/**
 * This page is a page object example Home Page
 */
public class HomePage extends BasePage {

    private final ElementsCollection menuMain = $$(byXpath("//*[@id='menu-main-menu']/li/a"));

    private final SelenideElement logo = $(byXpath("//*[@id='logo']")),
            contentSearch = $(byXpath("//div[@id='content']/p")),
            searchProduct = $(byXpath("//input[@class='search']"));


    public HomePage verifyMainMenuElements() {
        assertThat("Проверяем загрузку домашней стр.", isPageLoaded());
        return new HomePage();
    }

    /**
     * Осуществляем переход на дом. стр.
     *
     * @return
     */
    public HomePage goToHomePage() {
        open("/");
        assertThat("Проверяем загрузку домашней стр.", isPageLoaded());
        return new HomePage();
    }

    /**
     * Поиск товара по имени
     *
     * @param productName искомое имя продукта
     * @return HomePage
     */
    public HomePage checkTheProductSearch(String productName) {
        inputStringField(searchProduct, productName);
        searchProduct.pressEnter();
        return new HomePage();
    }

    /**
     * Проверяем результат некорректного поиска
     *
     * @param verifyResult значение для верификации
     */
    public HomePage verifyInvalidResultSearch(String verifyResult) {
        contentSearch.shouldHave(text(verifyResult));
        return this;
    }

    /**
     * Проверяем результат корректного поиска
     *
     * @param verifyResult значение для верификации
     */
    public HomePage verifyValidResultSearch(String verifyResult) {
        $(By.xpath("//div[contains(@id,'grid_view_products_page_container')]//h2/a[contains(text(),'" + verifyResult + "')]"))
                .shouldBe(visible);
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

}
