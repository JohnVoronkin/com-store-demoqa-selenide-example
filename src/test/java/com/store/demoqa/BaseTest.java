package com.store.demoqa;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.store.demoqa.utils.PropertiesReader.loadProperty;

public abstract class BaseTest {

    @BeforeClass
    public static void beforeTestRunSetup() throws Exception {
        setDriverByName("chrome");
        baseUrl = "http://store.demoqa.com";
    }

    /**
     * Instance browser by name
     *
     * @param browser name browser
     * @throws Exception
     */
    private static void setDriverByName(String browser) throws Exception {

        if (browser == null || browser.isEmpty()) {
            throw new IllegalStateException("'browser' property is missing!");
        }

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
                throw new IllegalArgumentException("Browser " + browser + " not supported in test");
        }
    }

}


