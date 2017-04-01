package com.store.demoqa.model;


import static io.qala.datagen.RandomShortApi.*;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class UserAccount {

    private String userName = "";
    private String password = "";

    /**
     * userName for account user
     */
    public String getUserName() {
        return userName;
    }

    public UserAccount setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * password for account user
     */
    public String getPassword() {
        return password;
    }

    public UserAccount setPassword(String password) {
        this.password = password;
        return this;
    }

    private String userNameBlankOrEnglish = blankOr(english(1, 10));
    private String passwordBlankOrEnglish = isBlank(userNameBlankOrEnglish) ? blankOr(english(10)) : nullOrBlank();

    public UserAccount randomValue() {
        return new UserAccount()
                .setUserName(userNameBlankOrEnglish)
                .setPassword(passwordBlankOrEnglish);
    }

}
