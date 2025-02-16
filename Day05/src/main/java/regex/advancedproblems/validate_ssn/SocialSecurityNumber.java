package regex.advancedproblems.validate_ssn;

import static java.lang.System.*;
public class SocialSecurityNumber {
    // Method for Social Security Number (SSN)
    public static boolean validateSSN(String ssn) {
        return ssn.matches("\\d{3}-\\d{2}-\\d{4}");
    }
    public static void main(String[] args) {
        String text="My SSN is 123-45-6789.";

        if(validateSSN(text))
            out.println("valid SSN");
        else
            out.println("Invalid SSN");
    }
}
