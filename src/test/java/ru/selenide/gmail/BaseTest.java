package ru.selenide.gmail;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.BeforeClass;

import static com.codeborne.selenide.Configuration.baseUrl;
import static ru.selenide.gmail.utils.PropertiesReader.loadProperty;

public abstract class BaseTest {

    @BeforeClass
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
    public static void setDriverByName(String browser) throws Exception {
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
