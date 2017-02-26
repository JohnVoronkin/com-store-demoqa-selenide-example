package ru.selenide.gmail;

import org.junit.BeforeClass;

import static ru.selenide.gmail.utils.PropertiesReader.loadProperty;
import static ru.selenide.gmail.utils.SetDriverByName.setDriverByName;

public abstract class BaseTest {

    @BeforeClass
    public static void beforeTestRunSetup() throws Exception {
        setDriverByName(loadProperty("CHROME"));
    }

}
