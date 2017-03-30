package ru.selenide.gmail.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.NoSuchElementException;
import ru.selenide.gmail.base.BasePage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * This page is a page object example GmailHomePage
 */
public class GmailHomePage extends BasePage {

    private final ElementsCollection gmailNavLinksButtons = $$(byXpath("//div[@class='gmail-nav__nav-links-wrap']/a[not(@class='gmail-nav__nav-link gmail-nav__nav-link__get-gmail')]"));

    private final SelenideElement signIn = $(byXpath("//a[contains(@class,'sign-in')]"));


    public ServiceLoginPage signInAccountsGoogle() {
        assertThat("Проверяем загрузку домашней стр. Gmail", isPageLoaded());
        signIn.click();
        return new ServiceLoginPage();
    }


    @Override
    public boolean isPageLoaded() {
        try {
            gmailNavLinksButtons.shouldBe(size(3));
            return true;
        } catch (NoSuchElementException | ElementNotFound ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
