package ru.selenide.gmail.pages;

/**
 * Навигация меню (URL) по системе
 */
public enum URLMenu {

    HOME_PAGE_GMAIL("/"),
            ;

    private String menuURL;

    URLMenu(String menuURL) {
        this.menuURL = menuURL;
    }

    public String getMenuURL() {
        return menuURL;
    }
}
