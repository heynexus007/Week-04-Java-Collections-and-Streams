package regex.replaceandmodifystring.censorbadwords;

import java.util.*;
import static java.lang.System.*;

public class CensorBadWords {
    // Method to replace Bad Words by ****
    public static void replaceBadWordz(String text){
        List<String> badword=Arrays.asList("damn","stupid","mad","WTF","idiots","idiots");
        for(String word: badword){
            text=text.replaceAll("(?i)\\b"+word+"\\b","****");
        }
        out.println(text);
    }
    public static void main(String[] args) {
        String text="This is a damn bad example with some stupid words.";

        replaceBadWordz(text);
    }
}
