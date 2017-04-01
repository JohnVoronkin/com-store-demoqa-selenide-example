package com.store.demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.store.demoqa.base.BasePage;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

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
     * @return
     */
    public HomePage goToHomePage() {
        open("/");
        assertThat("Проверяем загрузку домашней стр.", isPageLoaded());
        return new HomePage();
    }

    /**
     * Поиск товаров
     *
     * @param productName передаваемое значение (искомомое значение для поиска)
     * @return HomePage()
     */
    public HomePage checkTheProductSearch(String productName, String verifyResult) {
        inputStringField(searchProduct, productName);
        searchProduct.pressEnter();
        contentSearch.shouldHave(text(verifyResult));
        return new HomePage();
    }

    @Override
    public boolean isPageLoaded() {
        try {
            menuMain.shouldBe(size(4));
            logo.shouldBe(Condition.visible);
            return true;
        } catch (NoSuchElementException | ElementNotFound ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
