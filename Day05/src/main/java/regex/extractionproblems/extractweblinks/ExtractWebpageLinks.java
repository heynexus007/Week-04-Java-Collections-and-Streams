package regex.extractionproblems.extractweblinks;

import java.util.regex.*;
import static java.lang.System.*;

public class ExtractWebpageLinks {
    // Method to extract all web page links from a Sentences
    public static void extractCapitalWordz(String text){
        String regex="https?://(www\\.)?([a-zA-Z0-9.-]+)";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);
        while (matcher.find()){
            out.print(matcher.group()+", ");
        }
    }
    public static void main(String[] args) {
        String text="Visit https://www.google.com and http://example.org for more info.";

        extractCapitalWordz(text);
    }
}
