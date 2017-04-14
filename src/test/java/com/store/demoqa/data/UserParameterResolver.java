package com.store.demoqa.data;

import com.store.demoqa.model.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * data User
 */
public class UserParameterResolver implements ParameterResolver {

    private List<User> users = new ArrayList<>();

    public Stream<User> users() {
        return getAllUsers().stream();
    }

    /*
    Метод getAllUsers собирает данные в коллекцию List
     */
    private List<User> getAllUsers() {
        if (users.isEmpty()) {
            users = Arrays.asList(
                    new User().randomBlankOrEnglishValue(),
                    new User().randomBlankOrEnglishValue(),
                    new User().randomBlankOrEnglishValue(),
                    new User().randomBlankOrEnglishValue());
        }
        return users;
    }

    @Override
    public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(User.class);
    }

    @Override
    public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return users();

    }
}
