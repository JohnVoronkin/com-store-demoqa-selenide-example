package ru.selenide.gmail.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.NoSuchElementException;
import ru.selenide.gmail.base.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * This page - ServiceLoginPage
 */
public class ServiceLoginPage extends BasePage {


    private final SelenideElement formSignIn = $(".card.signin-card.pre-shift.no-name"),
            bannerText = $(byXpath("//div[@class='banner']/h1")),
            email = $("#Email");


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
