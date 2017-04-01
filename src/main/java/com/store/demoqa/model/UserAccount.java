package com.store.demoqa.model;


public class UserAccount {

    private String email = "";
    private String password = "";

    /**
     * email for account user
     */
    public String getEmail() {
        return email;
    }

    public UserAccount setEmail(String email) {
        this.email = email;
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

}
