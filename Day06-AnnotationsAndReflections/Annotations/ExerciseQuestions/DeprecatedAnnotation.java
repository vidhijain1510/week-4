package com.capgeminitraining.week4.day6annotationsreflection.annotations.exercisequestion;

class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("Warning: This is an old feature and should not be used.");
    }

    public void newFeature() {
        System.out.println("This is the new recommended feature.");
    }
}

public class DeprecatedAnnotation {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        // Calling the deprecated method (Compiler warning expected)
        api.oldFeature();

        // Calling the new method
        api.newFeature();
    }
}
