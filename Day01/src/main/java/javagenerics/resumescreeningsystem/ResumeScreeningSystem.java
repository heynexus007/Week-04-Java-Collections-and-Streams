package javagenerics.resumescreeningsystem;

import java.util.*;
import static java.lang.System.*;

// Abstract Job Role class
abstract class JobRole {
    String name;

    protected JobRole(String name) {
        this.name = name;
    }

    abstract void processResume();
}

// Software Engineer Role
class SoftwareEngineer extends JobRole {
    int codingExp; // Years of coding experience

    public SoftwareEngineer(String name, int codingExp) {
        super(name);
        this.codingExp = codingExp;
    }

    @Override
    void processResume() {
        out.println("Software Engineer Resume: " + name + ", Coding Experience: " + codingExp + " years");
    }
}

// Data Scientist Role
class DataScientist extends JobRole {
    int mlExp; // Years of Machine Learning experience

    public DataScientist(String name, int mlExp) {
        super(name);
        this.mlExp = mlExp;
    }

    @Override
    void processResume() {
        out.println("Data Scientist Resume: " + name + ", ML Experience: " + mlExp + " years");
    }
}

// Product Manager Role
class ProductManager extends JobRole {
    int projHandled; // Number of projects managed

    public ProductManager(String name, int projHandled) {
        super(name);
        this.projHandled = projHandled;
    }

    @Override
    void processResume() {
        out.println("Product Manager Resume: " + name + ", Projects Handled: " + projHandled);
    }
}

// Generic Resume Processor
class Resume<T extends JobRole> {
    private List<T> resumes = new ArrayList<>();

    public void addResume(T resume) {
        resumes.add(resume);
    }

    public void processAll() {
        for (T resume : resumes) {
            resume.processResume();
        }
    }

    // Generic method to process a batch of resumes
    public static <T extends JobRole> void processBatch(List<T> resumes) {
        out.println("Processing Batch Resumes---");
        for (T resume : resumes) {
            resume.processResume();
        }
    }

    // Wildcard method to process any type of job role
    public static void processPipeline(List<? extends JobRole> resumes) {
        out.println("Screening Pipeline Processing---");
        for (JobRole resume : resumes) {
            resume.processResume();
        }
    }
}
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResumes = new Resume<>();
        seResumes.addResume(new SoftwareEngineer("Drake", 5));
        seResumes.addResume(new SoftwareEngineer("Jack", 3));

        Resume<DataScientist> dsResumes = new Resume<>();
        dsResumes.addResume(new DataScientist("Charlie", 4));
        dsResumes.addResume(new DataScientist("Dormann", 6));

        Resume<ProductManager> pmResumes = new Resume<>();
        pmResumes.addResume(new ProductManager("Envy", 8));
        pmResumes.addResume(new ProductManager("Franklin", 5));

        out.println("--------Software Engineer Resumes--------");
        seResumes.processAll();

        out.println("\n---------Data Scientist Resumes---------");
        dsResumes.processAll();

        out.println("\n----------Product Manager Resumes----------");
        pmResumes.processAll();

        // Using generic method to process a batch of resumes
        List<JobRole> batchResumes = new ArrayList<>();
        batchResumes.add(new SoftwareEngineer("Trilokeshwera", 7));
        batchResumes.add(new DataScientist("Avatar", 5));
        batchResumes.add(new ProductManager("Samiksha", 10));

        out.println("\nBatch Processing :");
        Resume.processBatch(batchResumes);

        // Using wildcard method to process resumes dynamically
        out.println("\nScreening Processing :");
        Resume.processPipeline(batchResumes);
    }
}
