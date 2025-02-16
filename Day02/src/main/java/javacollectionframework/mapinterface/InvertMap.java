package javacollectionframework.mapinterface;
import java.util.*;
import static java.lang.System.*;
public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        Map<Integer, List<String>> invertedMap = new HashMap<>();

        // Invert the map
        for (Map.Entry<String, Integer> e : originalMap.entrySet()) {
            invertedMap.computeIfAbsent(e.getValue(), k -> new ArrayList<>()).add(e.getKey());
        }

        out.println(invertedMap);
    }
}
