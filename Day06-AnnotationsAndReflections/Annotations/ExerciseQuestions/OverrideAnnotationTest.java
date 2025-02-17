package com.capgeminitraining.week4.day6annotationsreflection.annotations.exercisequestion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OverrideAnnotationTest {
    @Test
    void testDogOverride() {
        Animal myDog = new Dog();

        // Capture console output
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        myDog.makeSound();
        String output = out.toString().trim();

        assertEquals("Dog barks.", output);
    }

    @Test
    void testAnimalMakeSound() {
        Animal animal = new Animal();

        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        animal.makeSound();
        String output = out.toString().trim();

        assertEquals("Animal makes a sound.", output);
    }

}