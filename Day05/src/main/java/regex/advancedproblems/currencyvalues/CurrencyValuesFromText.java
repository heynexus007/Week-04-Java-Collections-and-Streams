package regex.advancedproblems.currencyvalues;

import java.util.*;
import java.util.regex.*;
import static java.lang.System.*;
public class CurrencyValuesFromText {
    // Method for extracting Currency Values
    public static List<String> extractCurrencyValues(String text) {
        List<String> values = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\$?\\d+\\.\\d{2}").matcher(text);
        while (matcher.find()) {
            values.add(matcher.group());
        }
        return values;
    }
    public static void main(String[] args) {
        String text="The price is $45.99, and the discount is 10.50.";
        out.println(extractCurrencyValues(text));
    }
}
