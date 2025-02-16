package reflection_in_java.basic_level.accessprivate;

import java.lang.reflect.*;
import static java.lang.System.*;
class Person {
    private int age = 25;
}
public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Field field = Person.class.getDeclaredField("age");
        // Allow access to private field
        field.setAccessible(true);

        out.println("Original Age : " + field.get(person));
        field.set(person, 30);
        out.println("Modified Age : " + field.get(person));
    }
}
