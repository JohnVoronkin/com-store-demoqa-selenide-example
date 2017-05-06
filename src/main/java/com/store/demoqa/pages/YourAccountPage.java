package com.store.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.store.demoqa.base.BasePage;
import com.store.demoqa.base.LoadablePage;
import com.store.demoqa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.store.demoqa.pages.URLMenu.YOUR_ACCOUNT_PAGE;
import static com.store.demoqa.utils.DefaultData.DEFAULT_LOGIN;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.openqa.selenium.By.xpath;

/**
 * This page - Your Account Page
 */
public class YourAccountPage extends BasePage implements LoadablePage {

    private final SelenideElement userName = $(byCssSelector("#log")),
            password = $(byCssSelector("#pwd")),
            login = $(byCssSelector("#login")),
            menuOnlineStore = $(byXpath("//li[@id='wp-admin-bar-site-name' and @class='menupop']")),
            logout = $(byCssSelector("#wp-admin-bar-logout > a"));

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
        $(xpath(".//*[@id='wp-admin-bar-my-account']/a")).shouldHave(text("Howdy, " + DEFAULT_LOGIN));
        return this;
    }

    /**
     * Выход из системы
     *
     * @return ToolsQALoggedOutPage()
     */
    public ToolsQALoggedOutPage logout() {
        $(xpath(".//*[@id='wp-admin-bar-my-account']/a")).shouldHave(text("Howdy, " + DEFAULT_LOGIN)).hover();
        sleep(200);
        logout.click();
        return new ToolsQALoggedOutPage();
    }

    /**
     * Невалидная авторизация
     *
     * @param users передаваемый логин и парль пользователя
     * @return YourAccountPage
     */
    public YourAccountPage noLogin(ArrayList<User> users) {
        for (User user : users) {
            this.userName.setValue(user.getUserName());
            this.password.setValue(user.getPassword());
            login.submit();
            try {
                $(byXpath("//strong[text()='ERROR']")).shouldBe(visible);
            } catch (NoSuchElementException | ElementNotFound ex) {
                $(byXpath("//p[text()='Please enter your username and password.']")).shouldBe(visible);
            }
        }
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
            fail("The required items on the page are not displayed");
            return false;
        }
    }

    @Override
    public void load() {
        open(YOUR_ACCOUNT_PAGE.getMenuURL());
        assertThat("Проверяем загрузку стр. авторизации", isPageLoaded());
    }

}