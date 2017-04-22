package com.store.demoqa.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public abstract class BasePage {

    public abstract boolean isPageLoaded();

    /**
     * Заполнение текстового поля
     *
     * @param input     идентификация поля по элементу в DOM
     * @param textField передаваемое значение текста
     */
    public static void inputStringField(SelenideElement input, String textField) {
        input.waitUntil(Condition.visible, 10000);
        input.setValue(textField);
        assertThat(input.getValue(), is(equalTo("" + textField + "")));
    }

    /**
     * Наличия элемента
     *
     * @param by передаваемый локатор элемента для представления
     */
    public static boolean isElementPresent(By by) {
        try {
            sleep(300);
            getWebDriver().findElement(by);
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        } catch (StaleElementReferenceException ignored) {
            return false;
        }
    }

    public static boolean isElementVisible(By by) {
        try {
            getWebDriver().findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        } catch (ElementNotVisibleException ignored) {
            return false;
        } catch (StaleElementReferenceException ignored) {
            return false;
        }
    }

    public static boolean isElementTextPresent(By by, String text) {
        try {
            if (getWebDriver().findElement(by).getText().equals(text)) {
                return true;
            }
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
