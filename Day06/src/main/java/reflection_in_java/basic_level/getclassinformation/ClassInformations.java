package reflection_in_java.basic_level.getclassinformation;

import java.lang.reflect.*;
import static java.lang.System.*;
public class ClassInformations {
    public static void main(String[] args) throws Exception {
        // Change class name as needed
        Class<?> clazz = Class.forName("java.util.ArrayList");

        out.println("Methods : ");
        for (Method m : clazz.getDeclaredMethods()) {
            out.println(m);
        }

        out.println("\nFields : ");
        for (Field f : clazz.getDeclaredFields()) {
            out.println(f);
        }

        out.println("\nConstructors : ");
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            out.println(constructor);
        }
    }
}
