package javacollectionframework.mapinterface;

import java.util.*;
import static java.lang.System.*;
public class KeyWithHighestValue {
    public static void main(String[] args) {
        Map<String, Integer> hMap = new HashMap<>();
        hMap.put("A", 10);
        hMap.put("B", 20);
        hMap.put("C", 15);

        // Find the key with the highest value
        String maxKey = Collections.max(hMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        out.println("Key with highest value : " + maxKey);
    }
}
