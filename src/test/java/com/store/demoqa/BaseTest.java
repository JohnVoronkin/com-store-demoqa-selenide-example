package com.store.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.TextReport;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.rules.TestRule;

import java.util.stream.Stream;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.store.demoqa.pages.WarningMessages.INVALID_SEARCH;
import static com.store.demoqa.utils.PropertiesReader.loadProperty;
import static io.qala.datagen.RandomShortApi.numeric;
import static io.qala.datagen.RandomShortApi.unicode;
import static io.qala.datagen.RandomValue.length;
import static io.qala.datagen.StringModifier.Impls.prefix;
import static io.qala.datagen.StringModifier.Impls.specialSymbol;

public abstract class BaseTest {

    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);

    @BeforeAll
    public static void beforeTestRunSetup() throws Exception {
        setDriverByName(loadProperty("CHROME"));
        baseUrl = loadProperty("URL");
    }

    /**
     * Instance browser by name
     *
     * @param browser name browser
     * @throws Exception
     */
    private static void setDriverByName(String browser) throws Exception {
        switch (browser) {
            case "gecko":
                Configuration.browser = "gecko";
                FirefoxDriverManager.getInstance().setup();
                break;
            case "chrome":
                Configuration.browser = "chrome";
                ChromeDriverManager.getInstance().setup();
                break;
            case "ie":
                Configuration.browser = "ie";
                InternetExplorerDriverManager.getInstance().setup();
                break;
            case "edge":
                Configuration.browser = "edge";
                EdgeDriverManager.getInstance().setup();
                break;
            default:
                throw new IllegalStateException("Browser " + browser + " not supported in test");
        }
    }

}
