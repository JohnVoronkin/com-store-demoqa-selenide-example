package com.store.demoqa.utils;

import java.util.Random;

/**
 * data random generate
 */
public class DataRandomTest {

    private static Random random = new Random();

    /**
     * Метод генерирующий случайный email
     * <p>
     * пример - .sendKeys(randomEmail());
     */
    public static String randomEmail() {
        int lengthName = 10;
        int lengthFirstDomain = 5;
        int lengthSecondDomain = 3;

        String name = "0123456789abcdefghijklmnopqrstuvwxyz";
        String firstDomain = "0123456789abcdefghijklmnopqrstuvwxyz";
        String secondDomain = "abcdefghijklmnopqrstuvwxyz";

        String email = new String();
        StringBuilder sb = new StringBuilder(lengthName);
        for (int i = 0; i < lengthName; i++)
            sb.append(name.charAt(random.nextInt(name.length())));
        email += sb;

        sb = new StringBuilder(lengthFirstDomain);
        for (int i = 0; i < lengthFirstDomain; i++)

            sb.append(firstDomain.charAt(random.nextInt(firstDomain.length())));
        email += "@" + sb;

        sb = new StringBuilder(lengthSecondDomain);
        for (int i = 0; i < lengthSecondDomain; i++)
            sb.append(secondDomain.charAt(random.nextInt(secondDomain.length())));
        email += "." + sb;

        return email;
    }

}
