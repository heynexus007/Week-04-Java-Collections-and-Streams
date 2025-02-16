package regex.extractionproblems.extractdateformat;

import java.util.regex.*;
import static java.lang.System.*;

public class ExtractDateFormat {
    // Method to extract all dates from a Sentences
    public static void extractCapitalWordz(String text){
        String regex="[0-9/]{2,}";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);
        while (matcher.find()){
            out.print(matcher.group()+",");
        }
    }
    public static void main(String[] args) {
        String text="The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        extractCapitalWordz(text);
    }
}
