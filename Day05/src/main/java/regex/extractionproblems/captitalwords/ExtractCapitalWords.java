package regex.extractionproblems.captitalwords;
import java.util.regex.*;
import static java.lang.System.*;
public class ExtractCapitalWords {
    public static void extractCapitalWordz(String text){
        String regex="[^A-Z][A-Z][a-z]{2,}";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);
        while (matcher.find()){
            out.print(matcher.group()+",");
        }
    }
    public static void main(String[] args) {
        String text="The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        extractCapitalWordz(text);
    }
}
