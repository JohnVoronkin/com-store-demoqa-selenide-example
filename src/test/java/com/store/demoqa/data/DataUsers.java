package com.store.demoqa.data;

import com.store.demoqa.model.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * data User
 */
public class DataUsers {


    // Пользователи
    private static ArrayList<User> user = new ArrayList<>();

    public int sizeUsers() {
        return user.size();
    }

    /**
     * Инициализация объекта - Пользователь
     *
     * @return коллекция объект - Пользователь
     */
    private static ArrayList<User> getUsers() {
        ArrayList<User> users = user;
        if (user.isEmpty()) {
            users.add(new User().randomBlankOrEnglishValue());
            users.add(new User().randomBlankOrEnglishValue());
            users.add(new User().randomBlankOrEnglishValue());
            users.add(new User().randomBlankOrEnglishValue());
            users.add(new User().randomBlankOrEnglishValue());
        }
        return users;
    }

    @DataProvider
    public Object[][] DataProviderUsers() {

        return new Object[][]{
                {
                        getUsers()
                },
        };

    }
}
