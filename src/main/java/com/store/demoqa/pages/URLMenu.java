package com.store.demoqa.pages;

/**
 * Navigation on the menu by direct URL
 */
public enum URLMenu {

    HOME_PAGE("/"),
    YOUR_ACCOUNT_PAGE("/products-page/your-account/"),;

    private String menuURL;

    URLMenu(String menuURL) {
        this.menuURL = menuURL;
    }

    public String getMenuURL() {
        return menuURL;
    }
}
