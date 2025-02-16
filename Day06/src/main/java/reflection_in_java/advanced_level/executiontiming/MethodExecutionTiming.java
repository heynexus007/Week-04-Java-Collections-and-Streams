package reflection_in_java.advanced_level.executiontiming;

import java.lang.reflect.*;
import static java.lang.System.*;
class Task {
    public void runTask() {
        for (int i = 0; i < 1000000; i++);
    }
}
public class MethodExecutionTiming {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Method method = Task.class.getMethod("runningTask");

        long start = System.nanoTime();
        method.invoke(task);
        long end = System.nanoTime();

        out.println("Execution time : " + (end - start) + " ns");
    }
}
