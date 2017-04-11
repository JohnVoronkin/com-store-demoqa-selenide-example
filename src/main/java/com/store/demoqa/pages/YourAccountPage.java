package com.store.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.store.demoqa.base.BasePage;
import com.store.demoqa.model.UserAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.store.demoqa.pages.URLMenu.YOUR_ACCOUNT_PAGE;
import static com.store.demoqa.utils.DefaultData.DEFAULT_LOGIN;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This page - Your Account Page
 */
public class YourAccountPage extends BasePage {

    private final SelenideElement userName = $(byCssSelector("#log")),
            password = $(byCssSelector("#pwd")),
            login = $(byCssSelector("#login")),
            menuOnlineStore = $(byXpath("//li[@id='wp-admin-bar-site-name' and @class='menupop']"));

    /**
     * Переходим на стр. авторизации в магазин
     *
     * @return YourAccountPage
     */
    public YourAccountPage goToYourAccountPage() {
        open(YOUR_ACCOUNT_PAGE.getMenuURL());
        assertThat("Проверяем загрузку стр. авторизации", isPageLoaded());
        return new YourAccountPage();
    }

    /**
     * Авторизация в систему
     *
     * @param userName передаваемый логи пользователя
     * @param password передаваемый пароль пользователя
     * @return YourAccountPage
     */
    public YourAccountPage loginAs(String userName, String password) {
        this.userName.setValue(userName);
        this.password.setValue(password);
        login.submit();
        menuOnlineStore.waitUntil(visible, 10000);
        $(By.xpath(".//*[@id='wp-admin-bar-my-account']/a")).shouldHave(text("Howdy, " + DEFAULT_LOGIN));
        return this;
    }

    /**
     * Невалидная авторизация
     *
     * @param userAccount передаваемый логин и парль пользователя
     * @return YourAccountPage
     */
    public YourAccountPage noLogin(UserAccount userAccount) {
        this.userName.setValue(userAccount.getUserName());
        this.password.setValue(userAccount.getPassword());
        login.submit();
        $(byXpath("//strong[text()='ERROR']")).shouldBe(visible);
        return this;
    }

    @Override
    public boolean isPageLoaded() {
        try {
            userName.shouldBe(visible);
            password.shouldBe(visible);
            login.shouldBe(visible);
            return true;
        } catch (NoSuchElementException | ElementNotFound ex) {
            ex.printStackTrace();
            return false;
        }
    }

}