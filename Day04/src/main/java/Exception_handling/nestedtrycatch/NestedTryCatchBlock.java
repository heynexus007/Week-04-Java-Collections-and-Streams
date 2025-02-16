package Exception_handling.nestedtrycatch;

import java.util.*;
import static java.lang.System.*;
public class NestedTryCatchBlock {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        int[] arr=new int[4];
        out.print("Enter 4 elements in Array : ");
        for(int i=0;i<arr.length;i++){
            arr[i]=input.nextInt();
        }
        out.print("Enter divisor : ");
        int divisor=input.nextInt();

        out.print("Enter index to access element : ");
        int index=input.nextInt();

        try{
            out.println("Element is : "+arr[index]);
            try{
                out.println("Result after division : "+arr[index]/divisor);
            }catch (ArithmeticException e){
                out.println("ArithmeticException -> Cannot divide by zero!!!");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            out.println("Invalid array index!!!");
        }
    }
}
