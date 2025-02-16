package javacollectionframework.mapinterface;
import java.util.*;
import static java.lang.System.*;
public class ShoppingCart {
    // Method to add items to cart
    private static void addToCart(Map<String, Integer> cart, String product, int quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public static void main(String[] args) {
        // HashMap to store product prices
        HashMap<String, Double> productPrices = new HashMap<>();
        productPrices.put("Laptop", 67999.0);
        productPrices.put("Phone", 18999.0);
        productPrices.put("Headphones", 899.0);

        // LinkedHashMap to maintain order of added items
        LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
        addToCart(cart, "Laptop", 1);
        addToCart(cart, "Phone", 2);
        addToCart(cart, "Headphones", 1);

        out.println("Shopping Cart in Order : " + cart);

        // TreeMap to display products sorted by price
        TreeMap<Double, String> sortedByPrice = new TreeMap<>();
        for (Map.Entry<String, Double> e : productPrices.entrySet()) {
            sortedByPrice.put(e.getValue(), e.getKey());
        }

        out.println("Products sorted by its price : " + sortedByPrice);
    }
}
