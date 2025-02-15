package regex.basicregexproblems.validatelicenceplatenumber;

import java.util.Scanner;
import java.util.regex.*;
import static java.lang.System.*;

public class LicensePlateNumber {
    // Method for checking license plate number is valid or not
    public static boolean isLicenseNumberValid(String regex, String plateNumber){
        return Pattern.matches(regex,plateNumber);
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String regex="^[A-Z]{2}[0-9]{4}";
        out.println("Enter any License plate number : ");
        String plateNumber=input.next();

        if(isLicenseNumberValid(regex,plateNumber)){
            out.println("Valid");
        }
        else out.println("Invalid");
    }
}
