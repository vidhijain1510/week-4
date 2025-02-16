package com.capgeminitraining.week4.day6annotationsreflection.reflections.intermediatelevel;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

class ModifyStaticFieldTest {

    @Test
    void testModifyStaticApiKey() throws Exception {
        Class<?> configClass = Configuration.class;

        //Getting the private static field API_KEY
        Field apiKeyField = configClass.getDeclaredField("API_KEY");

        //Making it accessible for modification
        apiKeyField.setAccessible(true);

        //Modifying the static field
        apiKeyField.set(null, "TEST_KEY");

        //Verifying the modified value
        assertEquals("TEST_KEY", Configuration.getApiKey(), "API_KEY should be 'TEST_KEY'");
    }
}