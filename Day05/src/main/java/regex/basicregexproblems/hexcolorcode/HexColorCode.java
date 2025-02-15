package regex.basicregexproblems.hexcolorcode;

import java.util.Scanner;
import java.util.regex.*;
import static java.lang.System.*;
public class HexColorCode {
    // method for checking color code
    public static boolean isValidColorcode(String regex, String code){
        Pattern pattern= Pattern.compile(regex);
        Matcher m=pattern.matcher(code);

        return m.find();
        //return Pattern.matches(regex,code);
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String regex="^[#][0-9A-Fa-f]{6}";
        out.print("Enter Hex Color Code : ");
        String colorCode=input.next();

        if(isValidColorcode(regex,colorCode))
            out.println("Valid");
        else
            out.println("Invalid");
    }
}
