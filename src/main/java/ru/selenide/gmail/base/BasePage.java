package ru.selenide.gmail.base;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public abstract class BasePage {

    public abstract boolean isPageLoaded();

    /**
     * Реализация переход по разделам системы напрямую по точному URL
     *
     * @param URL передаваемая ссылка для навигации
     */
    public static void openSectionOnURL(String URL) {
        open(URL);
    }

    /**
     * Заполнение текстового поля
     *
     * @param input     идентификация поля по элементу в DOM
     * @param textField передаваемое значение текста
     */
    public static void inputField(SelenideElement input, String textField) {
        input.setValue(textField);
        assertThat(input.getValue(), is(equalTo("" + textField + "")));
    }

}
