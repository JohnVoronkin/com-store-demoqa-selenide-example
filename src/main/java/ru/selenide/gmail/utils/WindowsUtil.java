package ru.selenide.gmail.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Windows tab
 */
public class WindowsUtil {

    /**
     * Проверяем валидность ссылки
     *
     * @param titleWindow         передаваемый заголовок нового окна
     * @param verifyElementWindow передаваемый локатор для проверки валидации элемента в новом окне
     */
    public static void linkValidation(String titleWindow, SelenideElement verifyElementWindow) {
        String parentWindowHandler = getWebDriver().getWindowHandle(); // Window PopUp. Store your parent window
        switchTo().window(titleWindow);
        verifyElementWindow.shouldBe(Condition.visible);
        getWebDriver().close();
        getWebDriver().switchTo().window(parentWindowHandler);  // Switch back to parent window
    }

    /**
     * Открыть url в новом окне
     *
     * @param url - url страницы
     *            Пример - WebElement link = driver.findElement(By.tagName("a"));
     *            openInNewWindow(link.getAttribute("href"));
     */
    public static void openInNewWindow(String url) {
        executeJavaScript("window.open(arguments[0])", url);
    }

    /**
     * The code below will open the link in new Tab
     * <p/>
     * пример - driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpenInNewTab);
     */
    public static String selectLinkOpenInNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);

}
