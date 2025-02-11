/* Smart Warehouse Management System
Concepts: Generic Classes, Bounded Type Parameters, Wildcards
Problem Statement:
You are developing a Smart Warehouse System that manages different types of items like Electronics,
Groceries, and Furniture. The system should be able to store and retrieve items dynamically while maintaining type safety.
Hints:
Create an abstract class WarehouseItem that all items extend (Electronics, Groceries, Furniture).
Implement a generic class Storage<T extends WarehouseItem> to store items safely.
Implement a wildcard method to display all items in storage regardless of their type (List<? extends WarehouseItem>).*/
package com.capgeminitraining.week4;

import java.util.ArrayList;
import java.util.List;

//abstract class
abstract class WarehouseItem{
    private String name;

    public WarehouseItem(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public abstract void displayInfo();

}

//Subclass Electronics extending WarehouseItem Class
class Electronices extends WarehouseItem{
    private String brand;

    public Electronices(String name,String brand){
        super(name);
        this.brand=brand;
    }
    @Override
    public void displayInfo(){
        System.out.println("Electronics: "+getName()+" Brand Name: "+brand);
    }

}
//Subclass Grocery extending WarehouseItem Class
class Grocery extends WarehouseItem {
    private String expiryDate;

    public Grocery(String name,String expiryDate){
        super(name);
        this.expiryDate=expiryDate;
    }
    public void displayInfo(){
        System.out.println("Groceries: "+getName()+" Expiry Date: "+expiryDate);
    }

}
//Subclass Furniture extending WarehouseItem Class
class Furniture extends WarehouseItem{
    private String material;
    public Furniture(String name,String material){
        super(name);
        this.material=material;
    }
    public void displayInfo(){
        System.out.println("Material: "+getName()+" Material: "+material);
    }

}

//Generic T
class Storage<T extends WarehouseItem>{
    private List<T>items=new ArrayList<>();

    public void addItems(T item){
        items.add(item);
    }

    public T getItem(int index){
        if(index>=0 && index<items.size()){
            return items.get(index);
        }
        return null;
    }

    public List<T> getallItems(){
        return items;
    }
}

//Utility class with wildcard method to display all items
class Warehouseutils{
    public static void displayAllItems(List<? extends WarehouseItem> items){
        for(WarehouseItem item:items){
            item.displayInfo();
        }
    }
}

public class SmartWarehouseManagementSystem {
    //Main Method
    public static void main(String[] args) {
        Storage<Electronices> electronicesStorage=new Storage<>();
        Storage<Grocery>groceryStorage=new Storage<>();
        Storage<Furniture>furnitureStorage=new Storage<>();

        electronicesStorage.addItems(new Electronices("Laptop","HP"));
        electronicesStorage.addItems(new Electronices("SmartPhone","Apple"));

        groceryStorage.addItems(new Grocery("Milk","15-08-2025"));
        groceryStorage.addItems(new Grocery("Bread","13-09-2025"));

        furnitureStorage.addItems(new Furniture("Chair","Wood"));
        furnitureStorage.addItems(new Furniture("Table","Metal"));

        //Displaying Electronics
        System.out.println("Displaying Electronics:");
        Warehouseutils.displayAllItems(electronicesStorage.getallItems());

        //Displaying groceries
        System.out.println("Displaying Groceries:");
        Warehouseutils.displayAllItems(groceryStorage.getallItems());

        //Displaying
        System.out.println("Displaying furniture:");
        Warehouseutils.displayAllItems(furnitureStorage.getallItems());

    }

}