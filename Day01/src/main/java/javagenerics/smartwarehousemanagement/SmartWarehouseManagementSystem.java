package javagenerics.smartwarehousemanagement;

import java.util.*;
import static java.lang.System.*;

// Abstract class representing a warehouse item
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayDetails();
}

// Electronics class extending WarehouseItem
class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, String brand) {
        super(name);
        this.brand = brand;
    }

    @Override
    public void displayDetails() {
        out.println("Electronics : " + getName() + " -> Brand : " + brand);
    }
}

// Groceries class extending WarehouseItem
class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String name, String expiryDate) {
        super(name);
        this.expiryDate = expiryDate;
    }

    @Override
    public void displayDetails() {
        out.println("Groceries : " + getName() + " -> Expiry Date : " + expiryDate);
    }
}

// Furniture class extending WarehouseItem
class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, String material) {
        super(name);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        out.println("Furniture : " + getName() + " -> Material : " + material);
    }
}

// Generic Storage class
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public List<T> getItems() {
        return items;
    }

    // Display all items in storage
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayDetails();
        }
    }
}

public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {
        // Creating storages for different item types
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Adding items to storage
        electronicsStorage.addItem(new Electronics("Laptop", "TUF gaming"));
        electronicsStorage.addItem(new Electronics("Smartphone", "Samsung S24 Ultra"));

        groceriesStorage.addItem(new Groceries("Peanut butter", "2026-02-01"));
        groceriesStorage.addItem(new Groceries("Bread", "2025-03-06"));

        furnitureStorage.addItem(new Furniture("Desk", "Alloy Metal"));
        furnitureStorage.addItem(new Furniture("Bed", "Wooden"));

        // Displaying all items
        out.println("----Electronics Storage----");
        Storage.displayAllItems(electronicsStorage.getItems());

        out.println("\n----Groceries Storage----");
        Storage.displayAllItems(groceriesStorage.getItems());

        out.println("\n----Furniture Storage----");
        Storage.displayAllItems(furnitureStorage.getItems());
    }
}
