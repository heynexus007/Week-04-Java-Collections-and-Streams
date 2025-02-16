package javastreams.countwords;

import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class CountWords {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Read file and count word occurrences
        try (BufferedReader bReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bReader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-z ]", "").split(" ");
                for (String w : words) {
                    if (!w.isEmpty()) {
                        wordCountMap.put(w, wordCountMap.getOrDefault(w, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    // Sort words by frequency in descending order
    List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

    // Print top 5 words
        out.println("Top 5 most frequent words : ");
        sortedWords.stream().limit(5).forEach(entry ->
            out.println(entry.getKey() + " = " + entry.getValue()));
    }
}
