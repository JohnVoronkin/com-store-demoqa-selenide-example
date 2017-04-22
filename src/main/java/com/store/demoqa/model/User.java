package com.store.demoqa.model;

import static io.qala.datagen.RandomShortApi.*;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class User {

    private String userName = "";
    private String password = "";

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * userName for account user
     */
    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * password for account user
     */
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    private String userNameBlankOrEnglish = blankOr(english(1, 10));
    private String passwordBlankOrEnglish = isBlank(userNameBlankOrEnglish) ?
            blankOr(english(10)) : nullOrBlank();

    public User randomBlankOrEnglishValue() {
        return new User()
                .setUserName(userNameBlankOrEnglish)
                .setPassword(passwordBlankOrEnglish);
    }

    @Override
    public String toString() {
        return "User [name=" + userName + ", " +
                "age=" + password + "]"
                ;
    }


}
