package reflection_in_java.basic_level.invokeprivate;

import java.lang.reflect.*;
import static java.lang.System.*;
class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethods {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        // Allow invocation of private method
        method.setAccessible(true);

        int result = (int) method.invoke(calc, 5, 3);
        out.println("Multiplication Result : " + result);
    }
}
