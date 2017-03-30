package ru.selenide.gmail.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.NoSuchElementException;
import ru.selenide.gmail.base.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.selenide.gmail.pages.URLMenu.ACCOUNTS_GOOGLE_PAGE;

/**
 * This page - ServiceLoginPage
 */
public class ServiceLoginPage extends BasePage {

    private final SelenideElement formSignIn = $(".card.signin-card.pre-shift.no-name"),
            bannerText = $(byXpath("//div[@class='banner']/h1")),
            email = $("#Email");

    /**
     * Открываем стр. сервеса по авторизации на почту
     *
     * @return ServiceLoginPage() класс
     */
    public ServiceLoginPage goToURLAccountGooglePage() {
        open(ACCOUNTS_GOOGLE_PAGE.getMenuURL());
        assertThat("Проверяем загрузку стр. - сервис авторизации на почту", isPageLoaded());
        return new ServiceLoginPage();
    }

    /**
     * Заполняем поле email
     * @param email передаваемое значение email
     * @return ServiceLoginPage
     */
    public ServiceLoginPage fillTheEmail(String email) {
        assertThat("Проверяем загрузку стр. - сервис авторизации на почту", isPageLoaded());
        inputField(this.email, email);
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