package Exception_handling.multiple_catchblocks;
import java.util.*;
import static java.lang.System.*;

public class MultipleCatchBlocks {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        int[]arr;
        try{
            out.print("Enter size of Array : ");
            int n=input.nextInt();

            arr=new int[n];
            for(int i=0;i<n;i++){
                out.print("Enter "+(i+1)+" Elements Array : ");
                arr[i]=input.nextInt();
            }
            out.print("Enter Index number : ");
            int index=input.nextInt();
            out.println("Value at index "+index+" is "+arr[index]);

            try{
                if(arr==null)
                    throw new NullPointerException();
            }
            catch(NullPointerException e) {
                out.println("NullPointerException -> Array is not initialized!");
            }

        } catch (ArrayIndexOutOfBoundsException   e) {
            out.println("ArrayIndexOutOfBoundsException: "+e.getMessage());
        }

        finally {
            out.println("-----------STOP----------");
        }
    }
}
