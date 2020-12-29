package studio.blacktech.common;

import org.junit.jupiter.api.Test;

import java.security.Provider;
import java.security.Security;

public class ProviderTest {


    @Test
    void test() {


        for (Provider provider : Security.getProviders()) {
            String providerName = provider.getName();
            for (String stringPropertyName : provider.stringPropertyNames()) {
                System.out.println(providerName + " - " + provider.getProperty(stringPropertyName));
            }
        }


    }


}
