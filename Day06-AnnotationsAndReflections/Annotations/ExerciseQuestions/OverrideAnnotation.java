package com.capgeminitraining.week4.day6annotationsreflection.annotations.exercisequestion;

class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }
}

public class OverrideAnnotation {
    public static void main(String[] args) {
        Animal myDog = new Dog(); // Upcasting
        myDog.makeSound(); // Calls overridden method in Dog
    }
}
