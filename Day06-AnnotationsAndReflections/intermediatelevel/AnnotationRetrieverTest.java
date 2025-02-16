package com.capgeminitraining.week4.day6annotationsreflection.reflections.intermediatelevel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnnotationRetrieverTest {
    @Test
    void testAuthorAnnotationExists() {

        Class<Book> bookClass = Book.class;
        //Checking if @Author annotation is present
        assertTrue(bookClass.isAnnotationPresent(Author.class));
        //Retrieving the annotation
        Author authorAnnotation = bookClass.getAnnotation(Author.class);
        //Verifying the annotation value
        assertEquals("Vidhi Jain", authorAnnotation.name());
    }

    @Test
    void testNoAnnotationOnOtherClass() {
        class NoAnnotationClass {}

        //Ensuring NoAnnotationClass does not have @Author annotation
        assertFalse(NoAnnotationClass.class.isAnnotationPresent(Author.class), "NoAnnotationClass should not have @Author annotation");
    }

}