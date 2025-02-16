package regex.advancedproblems.validatecreditcard;

import static java.lang.System.*;
public class CreditCardNumber {
    public static boolean validateCreditCard(String cardNumber) {
        return cardNumber.matches("^4\\d{15}$") || cardNumber.matches("^5\\d{15}$");
    }

    public static void main(String[] args) {
        String cardNumber="4134340023567800";

        if(validateCreditCard(cardNumber))
            out.println("Valid Credit card number");
        else
            out.println("Invalid Credit card number");
    }
}
