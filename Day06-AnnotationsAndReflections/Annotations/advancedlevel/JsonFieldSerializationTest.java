package com.capgeminitraining.week4.day6annotationsreflection.annotations.advancedlevel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JsonFieldSerializationTest {
    @Test
    void testJsonSerialization() {
        User1 user = new User1("Vidhi", 21, "hiddenData");
        String json = JsonSerializer.serialize(user);

        assertTrue(json.contains("\"user_name\": \"Vidhi\""), "Username should be correctly serialized");
        assertTrue(json.contains("\"user_age\": \"21\""), "Age should be correctly serialized");
        assertFalse(json.contains("hiddenData"), "Fields without @JsonField should be ignored");
    }

    @Test
    void testEmptyObjectSerialization() {
        class EmptyUser {}
        EmptyUser emptyUser = new EmptyUser();
        String json = JsonSerializer.serialize(emptyUser);

        assertEquals("{}", json, "Empty class should serialize to empty JSON object");
    }
}