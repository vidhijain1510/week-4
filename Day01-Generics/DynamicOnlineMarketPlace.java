/*Dynamic Online Marketplace
Concepts: Type Parameters, Generic Methods, Bounded Type Parameters
Problem Statement:
Build a generic product catalog for an online marketplace that supports various product types like Books, Clothing, and Gadgets. Each product type has a specific price range and category.
Hints:
Define a generic class Product<T> where T is restricted to a category (BookCategory, ClothingCategory, etc.).
Implement a generic method to apply discounts dynamically (<T extends Product> void applyDiscount(T product, double percentage)).
Ensure type safety while allowing multiple product categories to exist in the same catalog.*/

package com.capgeminitraining.week4;

import java.util.ArrayList;
import java.util.List;

//Abstract Super class for product categories
abstract class ProductCategory {
    private String name;

    public ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

//Book Category class extending ProductCategory
class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Book");
    }
}

//Cloth Category class extending ProductCategory
class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

//Gadget Category class extending ProductCategory
class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadget");
    }
}

//Generic Product class with bounded type parameter
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + category.getName() + ") - INR" + price;
    }
}

//Generic method to apply discount
class DiscountManager {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Discount applied: " + product.getName() + " now INR" + product.getPrice());
    }
}

//Marketplace product Catalog
class ProductCatalog {
    private List<Product<?>> products = new ArrayList<>();

    public void addProduct(Product<?> product) {
        products.add(product);
    }

    public void showProducts() {
        for (Product<?> product : products) {
            System.out.println(product);
        }
    }
}

//Main class
public class DynamicOnlineMarketPlace {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        Product<BookCategory> book = new Product<>("Programming", 100.00, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Women's Top", 50.00, new ClothingCategory());
        Product<GadgetCategory> smartphone = new Product<>("Mobile Phone", 2000.00, new GadgetCategory());

        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(smartphone);

        System.out.println("Before Discount:");
        catalog.showProducts();

        DiscountManager.applyDiscount(book, 10);
        DiscountManager.applyDiscount(shirt, 15);
        DiscountManager.applyDiscount(smartphone, 5);

        System.out.println("\nAfter Discount:");
        catalog.showProducts();
    }
}