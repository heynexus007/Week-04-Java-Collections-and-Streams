package regex.basicregexproblems.validateusername;

import java.util.Scanner;
import java.util.regex.*;
import static java.lang.System.*;

public class ValidateUsername {
    public static boolean isValid(String regex,String txt) {
        return Pattern.matches(regex,txt);
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        String regex="^[a-z A-Z][A-Za-z0-9_]{5,15}$";

        out.println("Enter any username : ");
        String text=input.next();

        if(isValid(regex,text)){
            out.println("Valid");
        }
        else
            out.println("Invalid");
    }
}
