package com.store.demoqa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.store.demoqa.base.BasePage;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.store.demoqa.pages.URLMenu.YOUR_ACCOUNT_PAGE;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This page - Your Account Page
 */
public class YourAccountPage extends BasePage {

    private final SelenideElement formSignIn = $(".card.signin-card.pre-shift.no-name"),
            bannerText = $(byXpath("//div[@class='banner']/h1")),
            email = $("#Email");

    /**
     * Открываем стр. сервеса по авторизации на почту
     *
     * @return YourAccountPage() класс
     */
    public YourAccountPage goToURLAccountGooglePage() {
        Selenide.open(YOUR_ACCOUNT_PAGE.getMenuURL());
        assertThat("Проверяем загрузку стр. - сервис авторизации на почту", isPageLoaded());
        return new YourAccountPage();
    }

    /**
     * Заполняем поле email
     * @param email передаваемое значение email
     * @return YourAccountPage
     */
    public YourAccountPage fillTheEmail(String email) {
        assertThat("Проверяем загрузку стр. - сервис авторизации на почту", isPageLoaded());
        inputStringField(this.email, email);
        return this;
    }

    @Override
    public boolean isPageLoaded() {
        try {
            formSignIn.shouldBe(visible);
            bannerText.shouldBe(text("Один аккаунт. Весь мир Google!"));
            email.shouldBe(visible);
            return true;
        } catch (NoSuchElementException | ElementNotFound ex) {
            ex.printStackTrace();
            return false;
        }
    }

}