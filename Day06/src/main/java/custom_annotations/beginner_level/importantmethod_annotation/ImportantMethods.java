package custom_annotations.beginner_level.importantmethod_annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import static java.lang.System.*;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

// Class using the annotation
class TaskManager {
    @ImportantMethod(level = "HIGH")
    public void criticalTask() {
        out.println("Executing critical task....!");
    }

    @ImportantMethod(level = "MEDIUM")
    public void normalTask() {
        out.println("Executing normal task....!");
    }
}

public class ImportantMethods {
    public static void main(String[] args) {
        Method[] methods = TaskManager.class.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = m.getAnnotation(ImportantMethod.class);
                out.println("Method : " + m.getName() + " | Importance : " + annotation.level());
            }
        }
    }
}
