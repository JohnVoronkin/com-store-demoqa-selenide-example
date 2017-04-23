package com.store.demoqa.data;

import org.testng.annotations.DataProvider;

import static com.store.demoqa.utils.DefaultData.PRODUCT_IPHONE_4S_32;
import static io.qala.datagen.RandomShortApi.numeric;
import static io.qala.datagen.RandomShortApi.unicode;
import static io.qala.datagen.RandomValue.length;
import static io.qala.datagen.StringModifier.Impls.prefix;
import static io.qala.datagen.StringModifier.Impls.specialSymbol;


public class DataValueForSearch {

        @DataProvider
        public Object[][] dataProviderForSearch() {
            return new Object[][]{
                    {length(10).with(prefix("Search")).numeric()},
                    {length(20).with(specialSymbol()).english()},
                    {unicode(5, 10)},
                    {numeric(5, 19)},
                    {PRODUCT_IPHONE_4S_32},
            };
        }

}
