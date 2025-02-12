package javagenerics.onlinemarketplace;
import java.util.*;
import static java.lang.System.*;

// Enum for Book categories
enum BookCategory {
    FICTION, NON_FICTION, EDUCATIONAL, SCI_FI
}

// Enum for Clothing categories
enum ClothingCategory {
    MEN, WOMEN, KIDS
}

// Enum for Gadget categories
enum GadgetCategory {
    MOBILE, LAPTOP, ACCESSORY
}

// Abstract Product class
abstract class Product {
    private String name;
    private double price;

    protected Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void displayDetails();
}

// Book class extending Product
class Book extends Product {
    private BookCategory category;

    public Book(String name, double price, BookCategory category) {
        super(name, price);
        this.category = category;
    }

    public BookCategory getCategory() {
        return category;
    }

    @Override
    public void displayDetails() {
        out.println("Book: " + getName() + ", Category: " + category + ", Price: $" + getPrice());
    }
}

// Clothing class extending Product
class Clothing extends Product {
    private ClothingCategory category;

    public Clothing(String name, double price, ClothingCategory category) {
        super(name, price);
        this.category = category;
    }

    public ClothingCategory getCategory() {
        return category;
    }

    @Override
    public void displayDetails() {
        out.println("Clothing: " + getName() + ", Category: " + category + ", Price: " + getPrice()+" INR");
    }
}

// Gadget class extending Product
class Gadget extends Product {
    private GadgetCategory category;

    public Gadget(String name, double price, GadgetCategory category) {
        super(name, price);
        this.category = category;
    }

    public GadgetCategory getCategory() {
        return category;
    }

    @Override
    public void displayDetails() {
        out.println("Gadget: " + getName() + ", Category: " + category + ", Price: " + getPrice()+" INR");
    }
}

// Generic ProductCatalog class
class ProductCatalog<T extends Product> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public void removeProduct(T product) {
        products.remove(product);
    }

    public List<T> getProducts() {
        return products;
    }

    // Generic method to apply discounts
    public static <T extends Product> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        out.println("Discount applied!! New price of \"" + product.getName() + "\" is " + product.getPrice()+" INR");
    }

    // Method to display all products
    public void displayAllProducts() {
        for (T product : products) {
            product.displayDetails();
        }
    }
}

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        // Creating product catalogs
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        ProductCatalog<Gadget> gadgetCatalog = new ProductCatalog<>();

        // Adding products
        bookCatalog.addProduct(new Book("The MindSet", 499.00, BookCategory.FICTION));
         bookCatalog.addProduct(new Book("Java for Beginners", 699.00, BookCategory.EDUCATIONAL));

        clothingCatalog.addProduct(new Clothing("Sneaker", 1399.99, ClothingCategory.MEN));
        clothingCatalog.addProduct(new Clothing("Dress", 1600, ClothingCategory.WOMEN));

        gadgetCatalog.addProduct(new Gadget("iPhone", 89000, GadgetCategory.MOBILE));
        gadgetCatalog.addProduct(new Gadget("MacBook", 127999, GadgetCategory.LAPTOP));

        // Displaying products before applying discount
        out.println("--------Book Catalog--------");
        bookCatalog.displayAllProducts();

        out.println("\n--------Clothing Catalog--------");
        clothingCatalog.displayAllProducts();

        out.println("\n---------Gadget Catalog--------");
        gadgetCatalog.displayAllProducts();

        // Applying discounts
        out.println("\nApplying Discounts:");
        ProductCatalog.applyDiscount(bookCatalog.getProducts().get(0), 10); // 10% discount on first book
        ProductCatalog.applyDiscount(clothingCatalog.getProducts().get(1), 15); // 15% discount on dress
        ProductCatalog.applyDiscount(gadgetCatalog.getProducts().get(0), 5);  // 5% discount on smartphone

        // Displaying products after applying discount
        out.println("\nUpdated Book Catalog :");
        bookCatalog.displayAllProducts();

        out.println("\nUpdated Clothing Catalog :");
        clothingCatalog.displayAllProducts();

        out.println("\nUpdated Gadget Catalog :");
        gadgetCatalog.displayAllProducts();
    }
}
