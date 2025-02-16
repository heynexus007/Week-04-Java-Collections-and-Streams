package javacollectionframework.mapinterface;
import java.util.*;
import static java.lang.System.*;
public class WordFrequencyCounter {
    public static void main(String[] args) {
        String msg = "Hello world, hello Java!";
        Map<String, Integer> wordCount = new LinkedHashMap<>();

        // Convert to lowercase and split words
        String[] words = msg.toLowerCase().replaceAll("[^a-z ]", "").split(" ");

        // Count word frequency
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        out.println(wordCount);
    }
}
