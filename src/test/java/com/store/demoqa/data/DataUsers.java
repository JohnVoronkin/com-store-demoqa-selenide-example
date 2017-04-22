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
    public static ArrayList<User> getEmployees() {
        ArrayList<User> users = user;
        if (user.isEmpty()) {
            User user = new User().randomBlankOrEnglishValue();
            User user2 = new User().randomBlankOrEnglishValue();
            User user3 = new User().randomBlankOrEnglishValue();

            users.add(user);
            users.add(user2);
            users.add(user3);
        }

        return users;

    }


    @DataProvider
    public Object[][] objectDataEventTemplates() {


        return new Object[][]{
                {
                    getEmployees()
                },
        };

    }
}
