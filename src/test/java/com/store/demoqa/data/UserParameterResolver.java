package com.store.demoqa.data;

import com.store.demoqa.model.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

/**
 * data User
 */
public class UserParameterResolver implements ParameterResolver {


    @Override
    public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(User.class);
    }

    @Override
    public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return new User[]{new User().randomBlankOrEnglishValue(),
                new User().randomBlankOrEnglishValue(),
                new User().randomBlankOrEnglishValue()};


    }
}
