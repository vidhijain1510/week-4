package com.capgeminitraining.week4.day6annotationsreflection.annotations.exercisequestion;

import java.util.ArrayList;

public class UncheckedWarningAnnotation {

    @SuppressWarnings("unchecked")
    public void addElements() {
        ArrayList list = new ArrayList(); // Raw type (without generics)
        list.add("Hello");
        list.add(42);
        list.add(3.14);

        System.out.println("List elements: " + list);
    }

    public static void main(String[] args) {
        UncheckedWarningAnnotation demo = new UncheckedWarningAnnotation();
        demo.addElements();
    }
}
