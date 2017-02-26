package ru.selenide.gmail.tests;

import org.junit.Rule;
import org.junit.Test;
import ru.selenide.gmail.BaseTest;
import ru.selenide.gmail.pages.GmailHomePage;
import ru.selenide.gmail.rules.ScreenShotOnFailRule;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;


public class GmailTest extends BaseTest {

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Test
    public void testSearch() {
        GmailHomePage gmailHomePage = open("https://www.google.com/intl/ru/gmail/about/", GmailHomePage.class);
        assertTrue("Отображение кнопок - Создать аккаунт, Войти на дом. странице", gmailHomePage.hasResults());
    }

}
