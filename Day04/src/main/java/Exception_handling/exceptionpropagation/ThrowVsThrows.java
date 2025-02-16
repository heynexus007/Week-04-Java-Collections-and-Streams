package Exception_handling.exceptionpropagation;
import java.util.*;
import static java.lang.System.*;
public class ThrowVsThrows {
    public static void calculateInterest(double amount, double rate, int years){
        try{
            if(amount<0 && rate<0){
                throw new IllegalArgumentException();
            }
            out.println("Interest : "+(amount*rate*years));
        } catch (IllegalArgumentException e) {
            out.println("Invalid input!!! Amount and rate must be positive");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        out.print("Amount : ");
        double amount=input.nextDouble();
        out.print("Rate : ");
        double rate=input.nextDouble();
        out.print("Year : ");
        int years=input.nextInt();

        calculateInterest(amount,rate,years);
//        try{
//            calculateInterest(amount,rate,years);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

    }
}
