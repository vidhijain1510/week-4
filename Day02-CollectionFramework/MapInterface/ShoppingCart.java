/*Implement a Shopping Cart
Description:
Use HashMap to store product prices.
Use LinkedHashMap to maintain the order of items added.
Use TreeMap to display items sorted by price.
*/
package com.capgeminitraining.week4.day2.MapInterface;

import java.util.*;

public class ShoppingCart {
    private final HashMap<String, Double> productPrices;
    private final LinkedHashMap<String, Integer> cart;

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cart = new LinkedHashMap<>();
    }

    public void addProduct(String name, double price) {
        productPrices.put(name, price);
    }

    public void addToCart(String name, int quantity) {
        if (productPrices.containsKey(name)) {
            cart.put(name, cart.getOrDefault(name, 0) + quantity);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void displayCart() {
        System.out.println("Shopping Cart:");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " x " + entry.getValue() + " @ " + productPrices.get(entry.getKey()));
        }
    }

    public void displaySortedByPrice() {
        TreeMap<Double, String> sortedProducts = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            sortedProducts.put(productPrices.get(entry.getKey()), entry.getKey());
        }

        System.out.println("Cart Sorted by Price:");
        for (Map.Entry<Double, String> entry : sortedProducts.entrySet()) {
            System.out.println(entry.getValue() + " @ " + entry.getKey());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 0.75);
        cart.addProduct("Orange", 2.0);

        cart.addToCart("Apple", 2);
        cart.addToCart("Banana", 5);
        cart.addToCart("Orange", 3);

        cart.displayCart();
        cart.displaySortedByPrice();
    }
}
