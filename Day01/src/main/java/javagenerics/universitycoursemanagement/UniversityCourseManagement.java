package javagenerics.universitycoursemanagement;

import java.util.*;
import static java.lang.System.*;

// Abstract CourseType class
abstract class CourseType {
    String name;

    protected CourseType(String name) {
        this.name = name;
    }

    abstract void showDetails();
}

// Exam-Based Course
class ExamCourse extends CourseType {
    int duration; // in weeks

    public ExamCourse(String name, int duration) {
        super(name);
        this.duration = duration;
    }

    @Override
    void showDetails() {
        out.println("Exam Course: " + name + ", Duration: " + duration + " weeks");
    }
}

// Assignment-Based Course
class AssignmentCourse extends CourseType {
    int assignments;

    public AssignmentCourse(String name, int assignments) {
        super(name);
        this.assignments = assignments;
    }

    @Override
    void showDetails() {
        out.println("Assignment Course: " + name + ", Assignments: " + assignments);
    }
}

// Research-Based Course
class ResearchCourse extends CourseType {
    String topic;

    public ResearchCourse(String name, String topic) {
        super(name);
        this.topic = topic;
    }

    @Override
    void showDetails() {
        out.println("Research Course: " + name + ", Topic: " + topic);
    }
}

// Generic Course Manager
class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public void showCourses() {
        for (T course : courses) {
            course.showDetails();
        }
    }

    public static void displayAll(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.showDetails();
        }
    }
}
public class UniversityCourseManagement {
    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Java 101", 48));
        examCourses.addCourse(new ExamCourse("Basic Web Development ", 6));

        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("History 101", 5));
        assignmentCourses.addCourse(new AssignmentCourse("Literature 202", 7));

        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("AI Research", "Generative AI"));
        researchCourses.addCourse(new ResearchCourse("Quantum Mechanics", "Quantum Computing"));

        out.println("---------Exam Courses--------");
        examCourses.showCourses();

        out.println("\n---------Assignment Courses---------");
        assignmentCourses.showCourses();

        out.println("\n----------Research Courses----------");
        researchCourses.showCourses();

        // Using wildcard to handle any course type
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(new ExamCourse("Chemistry 101", 8));
        allCourses.add(new AssignmentCourse("OOPs 101", 5));
        allCourses.add(new ResearchCourse("Biotech Research", "Genetics"));

        out.println("\nAll Courses:");
        Course.displayAll(allCourses);
    }
}
