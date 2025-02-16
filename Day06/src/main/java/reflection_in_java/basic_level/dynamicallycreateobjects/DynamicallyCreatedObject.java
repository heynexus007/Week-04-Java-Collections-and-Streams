package reflection_in_java.basic_level.dynamicallycreateobjects;

import static java.lang.System.*;
class Student {
    public Student() {
        out.println("Student object created dynamically!");
    }
}

public class DynamicallyCreatedObject {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Student");
        Object obj = clazz.getDeclaredConstructor().newInstance();
    }
}
