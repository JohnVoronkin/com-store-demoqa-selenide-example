package com.store.demoqa.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.store.demoqa.base.BasePage;
import com.store.demoqa.base.LoadablePage;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.fail;

public class ToolsQALoggedOutPage extends BasePage implements LoadablePage {

    private final SelenideElement userLogin = $(byCssSelector("#user_login")),
            userPassword = $(byCssSelector("#user_pass"));


    @Override
    public boolean isPageLoaded() {
        try {
            userPassword.shouldBe(Condition.visible);
            userLogin.shouldBe(Condition.visible);
            return true;
        } catch (NoSuchElementException | ElementNotFound ex) {
            ex.printStackTrace();
            fail("The required items on the page are not displayed");
            return false;
        }
    }

    @Override
    public void load() {

    }

}
