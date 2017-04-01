package com.store.demoqa.base;

import com.codeborne.selenide.SelenideElement;

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
        input.setValue(textField);
        assertThat(input.getValue(), is(equalTo("" + textField + "")));
    }

}
