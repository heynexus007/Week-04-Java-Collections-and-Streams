package regex.advancedproblems.repeatingwords;

import java.util.*;
import java.util.regex.*;
import static java.lang.System.*;
public class FindRepeatWords {
    // Method to Find Repeating Words
    public static Set<String> findRepeatingWords(String text) {
        Set<String> repeatedWords = new HashSet<>();
        Matcher matcher = Pattern.compile("\\b(\\w+)\\s+\\1\\b").matcher(text);
        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));
        }
        return repeatedWords;
    }
    public static void main(String[] args) {
        String text="This is is a repeated repeated word test.";
        out.println(findRepeatingWords(text));
    }
}
