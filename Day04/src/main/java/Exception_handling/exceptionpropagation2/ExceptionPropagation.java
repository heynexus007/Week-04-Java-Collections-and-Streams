package Exception_handling.exceptionpropagation2;

import static java.lang.System.*;
public class ExceptionPropagation {
    public static void method1(int n) throws ArithmeticException{
            int res=n/0;
    }

    public static void method2(){
        // calls method1
        method1(10);
    }
    // main calls method2
    public static void main(String[] args) {
        try{
            method2();
        }
        catch (ArithmeticException e){
            out.println("Handled exception in main");
        }
    }
}
