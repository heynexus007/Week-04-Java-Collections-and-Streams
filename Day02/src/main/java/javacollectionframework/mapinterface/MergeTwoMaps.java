package javacollectionframework.mapinterface;

import java.util.*;
import static java.lang.System.*;
public class MergeTwoMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge two maps
        Map<String, Integer> mergedMap = new HashMap<>(map1);
        // If Key exists in 2nd Map its Integer value will be sumed
        map2.forEach((key, value) -> mergedMap.merge(key, value, Integer::sum));

        out.println(mergedMap);
    }
}
