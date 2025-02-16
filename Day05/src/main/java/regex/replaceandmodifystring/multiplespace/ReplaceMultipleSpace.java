package regex.replaceandmodifystring.multiplespace;

import java.util.regex.*;
import static java.lang.System.*;
public class ReplaceMultipleSpace {
    public static void main(String[] args) {
        String text="This is  an example   with multiple  spaces.";

        String replacedText=text.replaceAll("\\s+"," ");
        out.println(replacedText);
    }
}
