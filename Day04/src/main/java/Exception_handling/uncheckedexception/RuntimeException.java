package Exception_handling.uncheckedexception;

import java.util.*;
import static java.lang.System.*;

public class RuntimeException {
    public static void main(String[] args) {
        // Scanner for taking input
         Scanner input= new Scanner(System.in);
        out.println("Enter two numbers : ");
        // try for check and handle user Input is mismatched or not
        try{
            // Taking Two Numbers as input by user
            int x=input.nextInt();
            int y=input.nextInt();
            int divide;
            // try for check and handle Arithmetic Exception
            try{
                if(y==0){
                    divide=x/y;
                    out.println("Result after division : "+divide);
                }
                else{
                    divide=x/y;
                    out.println("Result after division : "+divide);
                }

            }catch (ArithmeticException e){ // catch the ArithmeticException
                out.println("ArithmeticException : "+e.getMessage());
            }
        }catch (InputMismatchException i){ // catch the InputMismatchException
            out.println("Input Mismatched Exception!!!!");
        }

        finally {
            out.println("-----------STOP----------");
        }
    }
}
