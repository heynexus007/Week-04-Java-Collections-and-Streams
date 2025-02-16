package Exception_handling.finallyblockexecution;

import java.util.*;
import static java.lang.System.*;
public class FinallyBlock {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        out.println("Enter two Integer : ");
        int x= input.nextInt();
        int y= input.nextInt();
        int divide;
        try {
            divide=x/y;
            out.println("Result : "+divide);
        } catch (ArithmeticException e) {
            out.println("ArithmeticException "+e.getMessage());
        }
        finally {
            out.println("Operation completed!!!");
        }

    }
}
