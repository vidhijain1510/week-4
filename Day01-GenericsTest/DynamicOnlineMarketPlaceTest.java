package com.capgeminitraining.week4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicOnlineMarketPlaceTest {
    private ProductCatalog catalog;
    private Product<BookCategory> book;
    private Product<ClothingCategory> shirt;
    private Product<GadgetCategory> mobilePhone;

    @BeforeEach
    void setUp() {
        catalog = new ProductCatalog();

        book = new Product<>("Programming", 59.99, new BookCategory());
        shirt = new Product<>("Cotton Shirt", 49.99, new ClothingCategory());
        mobilePhone = new Product<>("Mobile phone", 1999.99, new GadgetCategory());

        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(mobilePhone);
    }

    @Test
    void testProductCreation() {
        assertEquals("Programming", book.getName());
        assertEquals(59.99, book.getPrice(), 0.001);
        assertEquals("Book", book.getCategory().getName());

        assertEquals("Cotton Shirt", shirt.getName());
        assertEquals(49.99, shirt.getPrice(), 0.001);
        assertEquals("Clothing", shirt.getCategory().getName());

        assertEquals("Mobile phone", mobilePhone.getName());
        assertEquals(1999.99, mobilePhone.getPrice(), 0.001);
        assertEquals("Gadget", mobilePhone.getCategory().getName());
    }



    @Test
    void testingApplyDiscountMethod() {
        DiscountManager.applyDiscount(book, 10); //10%
        DiscountManager.applyDiscount(shirt, 15); //15%
        DiscountManager.applyDiscount(mobilePhone, 5); //5%

        assertEquals(53.99, book.getPrice(), 0.01);
        assertEquals(42.49, shirt.getPrice(), 0.01);
        assertEquals(1899.99, mobilePhone.getPrice(), 0.01);
    }
}