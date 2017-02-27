package ru.selenide.gmail.tests;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import ru.selenide.gmail.BaseTest;
import ru.selenide.gmail.pages.GmailHomePage;
import ru.selenide.gmail.rules.ScreenShotOnFailRule;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;


public class GmailTest extends BaseTest {

    private GmailHomePage gmailHomePage;

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void alwaysGoToLoginPage() {
        gmailHomePage = new GmailHomePage();
        open("/");
    }

    @Test
    public void validityLogInToYourAccount() {
        assertTrue("Check the page load", gmailHomePage.isPageLoaded());
    }

}
