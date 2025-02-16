package regex.advancedproblems.validateipaddress;

import java.util.regex.*;
import static java.lang.System.*;
public class ValidateIPAddress {
    public static boolean validateIPAddress(String ip) {
        String regex = "^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\." +
                "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\." +
                "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\." +
                "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";
        return Pattern.matches(regex, ip);
    }

    public static void main(String[] args) {
        String ipAddress="192.168.1.1";
        if(validateIPAddress(ipAddress))
            out.println("Valid IP Address");

        else
            out.println("Invalid IP Address");
    }
}
