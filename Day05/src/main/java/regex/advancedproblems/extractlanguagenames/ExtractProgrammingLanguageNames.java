package regex.advancedproblems.extractlanguagenames;

import java.util.*;
import java.util.regex.*;
import static java.lang.System.*;
public class ExtractProgrammingLanguageNames {
    public static List<String> extractProgrammingLanguages(String text) {
        List<String> languages = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b").matcher(text);
        while (matcher.find()) {
            languages.add(matcher.group());
        }
        return languages;
    }

    public static void main(String[] args) {
        String text="I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        out.println(extractProgrammingLanguages(text));
    }
}
