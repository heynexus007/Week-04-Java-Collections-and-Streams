package javacollectionframework.mapinterface;
import java.util.*;
import static java.lang.System.*;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}
public class GroupingObjects {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"));

        // Group employees by department
        Map<String, List<Employee>> groupedByDept = new HashMap<>();
        for (Employee e : employees) {
            groupedByDept.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }

        out.println(groupedByDept);
    }
}
