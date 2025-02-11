package com.capgeminitraining.week4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class StorageTest {
    @Test
    void testElectronics(){
        Storage<Electronices> electronicesStorage=new Storage<>();
        Electronices laptop = new Electronices( "Laptop", "Lenovo");
        electronicesStorage.addItems(laptop);

        Electronices retrieved = electronicesStorage.getItem(0);
        assertNotNull(retrieved);
        assertEquals("Laptop",retrieved.getName());

    }
    @Test
    void testGetAll() {
        Storage<Furniture> furnitureStorage = new Storage<>();
        Furniture chair = new Furniture("Bed", "Wood");
        Furniture table = new Furniture("Table", "Wood");

        furnitureStorage.addItems(chair);
        furnitureStorage.addItems(table);

        List<Furniture> items = furnitureStorage.getallItems();
        assertEquals(2, items.size());
        assertEquals("Bed", items.get(0).getName());
        assertEquals("Table", items.get(1).getName());
    }

    @Test
    void testDisplayAll() {
        Storage<Electronices> electronicsStorage = new Storage<>();
        electronicsStorage.addItems(new Electronices("Laptop", "Asus"));
        electronicsStorage.addItems(new Electronices("Smartphone", "Redmi"));

        assertDoesNotThrow(() -> Warehouseutils.displayAllItems(electronicsStorage.getallItems()));
    }

}