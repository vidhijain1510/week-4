package com.capgeminitraining.week4.day6annotationsreflection.reflections.advancedlevel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JsonSerializersTest {
    @Test
    void testToJson() {
        Person1 person = new Person1("Kapil", 25, false);
        String json = JsonSerializer.toJson(person);

        String expectedJson = "{\"name\": \"Kapil\", \"age\": 25, \"isActive\": false}";
        assertEquals(expectedJson, json, "JSON output should match expected format");
    }

    @Test
    void testNullObject() {
        String json = JsonSerializer.toJson(null);
        assertEquals("null", json, "Null object should return 'null' string");
    }

    @Test
    void testEmptyClass() {
        class EmptyClass {}

        String json = JsonSerializer.toJson(new EmptyClass());
        assertEquals("{}", json, "Empty class should return empty JSON object '{}'");
    }

}