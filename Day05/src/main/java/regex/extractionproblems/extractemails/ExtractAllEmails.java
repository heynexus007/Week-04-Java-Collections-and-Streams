package regex.extractionproblems.extractemails;

import java.util.regex.*;
import static java.lang.System.*;
public class ExtractAllEmails {
    public static void getAllEmails(String regex, String txt){
        // Method for checking all emails in a text and print
        Pattern p= Pattern.compile(regex);
        Matcher m= p.matcher(txt);
        while(m.find()){
            out.println(m.group());
        }
    }

    public static void main(String[] args) {
        String regex="[a-zA-Z0-9_.+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        String text="Contact us at support@example.com and info@company.org";

        getAllEmails(regex,text);
    }
}
