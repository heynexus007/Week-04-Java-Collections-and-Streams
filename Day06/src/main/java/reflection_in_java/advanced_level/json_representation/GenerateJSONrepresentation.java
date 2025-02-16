package reflection_in_java.advanced_level.json_representation;

import java.lang.reflect.*;
import static java.lang.System.*;
import java.util.*;

class Product {
    private String name = "TUF Gaming Laptop";
    private double price = 65999.99;
}
public class GenerateJSONrepresentation {
    public static String toJson(Object obj) throws Exception {
        Map<String, Object> jsonMap = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            jsonMap.put(field.getName(), field.get(obj));
        }
        return jsonMap.toString();
    }

    public static void main(String[] args) throws Exception {
        Product product = new Product();
        out.println(toJson(product));
    }
}
