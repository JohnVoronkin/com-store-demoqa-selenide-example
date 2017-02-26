package ru.selenide.gmail.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * This page is a page object example.
 */
public class GmailHomePage {

    private final ElementsCollection gmailNavLinksButtons =  $$(byXpath("//div[@class='gmail-nav__nav-links-wrap']/a[not(@class='gmail-nav__nav-link gmail-nav__nav-link__get-gmail')]"));


    public boolean hasResults() {
        return !gmailNavLinksButtons.isEmpty();
    }

}
