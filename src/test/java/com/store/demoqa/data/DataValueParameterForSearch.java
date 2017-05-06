package com.store.demoqa.data;

import com.store.demoqa.BaseTest;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ObjectArrayArguments;

import java.util.stream.Stream;

import static com.store.demoqa.utils.DefaultData.PRODUCT_IPHONE_4S_32;
import static io.qala.datagen.RandomShortApi.numeric;
import static io.qala.datagen.RandomShortApi.unicode;
import static io.qala.datagen.RandomValue.length;
import static io.qala.datagen.StringModifier.Impls.prefix;
import static io.qala.datagen.StringModifier.Impls.specialSymbol;

public class DataValueParameterForSearch implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> arguments(ContainerExtensionContext context) throws Exception {
        return Stream.of(length(10).with(prefix("Search")).numeric(),
                length(20).with(specialSymbol()).english(),
                unicode(5, 10),
                numeric(5, 19),
                PRODUCT_IPHONE_4S_32).map(ObjectArrayArguments::create);
    }
}
