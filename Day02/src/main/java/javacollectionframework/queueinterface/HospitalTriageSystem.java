package javacollectionframework.queueinterface;

import java.util.*;
import static java.lang.System.*;
class Patient implements Comparable<Patient> {
    String name;
    int severity; // Higher value means higher priority

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        // Higher severity first
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString() {
        return name + " (Severity -> " + severity + ")";
    }
}
public class HospitalTriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>();

        queue.add(new Patient("Rohan", 3));
        queue.add(new Patient("Yash", 5));
        queue.add(new Patient("Cornel", 2));

        out.println("Treatment Order :");
        while (!queue.isEmpty()) {
            out.println(queue.poll());
        }
    }
}
