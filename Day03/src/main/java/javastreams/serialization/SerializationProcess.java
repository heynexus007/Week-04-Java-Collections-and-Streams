package javastreams.serialization;

import java.io.*;
import java.util.*;
class Employee implements Serializable {
    int id;
    String name, department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + department + " - $" + salary;
    }
}
public class SerializationProcess {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "HR", 50000),
                new Employee(2, "Bob", "IT", 70000));

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.data"))) {
            oos.writeObject(employees);
            System.out.println("Employees saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.data"))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            deserializedEmployees.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
