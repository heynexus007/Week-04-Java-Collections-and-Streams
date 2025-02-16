package custom_annotations.intermediate_level.logging_execution_time;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

// Class using @LogExecutionTime
class PerformanceTester {
    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Executing fast method...");
    }

    @LogExecutionTime
    public void slowMethod() {
        try {
            Thread.sleep(2000); // Simulate a slow task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class LogExecutionTimeAnnotation {
    public static void main(String[] args) throws Exception {
        PerformanceTester tester = new PerformanceTester();
        Method[] methods = PerformanceTester.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(tester);
                long endTime = System.nanoTime();
                System.out.println("Execution time of " + method.getName() + ": " + (endTime - startTime) / 1_000_000 + " ms");
            }
        }
    }
}
