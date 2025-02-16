package custom_annotations.beginner_level.todo_annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import static java.lang.System.*;

// Define the ToDo annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

// Class using Todo annotation
class ProjectTasks {
    @Todo(task = "Implement login feature", assignedTo = "Rahul", priority = "HIGH")
    public void login() {}

    @Todo(task = "Optimize database queries", assignedTo = "Janvi")
    public void optimizeDB() {}

    @Todo(task = "Improve UI", assignedTo = "Priyansh", priority = "LOW")
    public void improveUI() {}
}

public class ToDoAnnotation {
    public static void main(String[] args) {
        Method[] methods = ProjectTasks.class.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo annotation = m.getAnnotation(Todo.class);
                out.println("Task : " + annotation.task() + " | Assigned to : " + annotation.assignedTo() +
                        " | Priority : " + annotation.priority());
            }
        }
    }
}
