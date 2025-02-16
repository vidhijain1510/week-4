/*Retrieve Annotations at Runtime: Create a custom annotation @Author(name="Author Name"). Apply it to a class and use Reflection to retrieve and display the annotation value at runtime.*/
package com.capgeminitraining.week4.day6annotationsreflection.reflections.intermediatelevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


//Defining custom annotation
@Retention(RetentionPolicy.RUNTIME)  //Annotation should be available at runtime
@interface Author {
    String name();
}
@Author(name = "Vidhi Jain")
class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

public class AnnotationRetriever {
    public static void main(String[] args) {
        //Getting the class object
        Class<Book> bookClass = Book.class;

        //Checking if the @Author annotation is present
        if (bookClass.isAnnotationPresent(Author.class)) {
            //Retrieving the annotation
            Author authorAnnotation = bookClass.getAnnotation(Author.class);

            //Displaying the annotation value
            System.out.println("Author: " + authorAnnotation.name());
        } else {
            System.out.println("No @Author annotation found.");
        }
    }
}
