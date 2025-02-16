package javacollectionframework.setinterface;
import java.util.*;
import static java.lang.System.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    // Sorting policies by expiry date (TreeSet requires Comparable implementation)
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{Number='" + policyNumber + "', Holder='" + policyholderName + "', Expiry=" + expiryDate +
                ", Type='" + coverageType + "', Premium=" + premiumAmount + "}";
    }
}


public class InsurancePolicyManagementSystem{
private Set<Policy> hashSetPolicies = new HashSet<>();
private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
private Set<Policy> treeSetPolicies = new TreeSet<>();

// Add policy to all sets
public void addPolicy(Policy policy) {
    hashSetPolicies.add(policy);
    linkedHashSetPolicies.add(policy);
    treeSetPolicies.add(policy);
}

// Display all policies
public void displayAllPolicies() {
    out.println("\nAll Policies (By HashSet):");
    hashSetPolicies.forEach(out::println);
}

// Get policies expiring within the next 30 days
public List<Policy> getExpiringSoonPolicies() {
    List<Policy> expiringPolicies = new ArrayList<>();
    Date today = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(today);
    calendar.add(Calendar.DAY_OF_YEAR, 30);
    Date thresholdDate = calendar.getTime();

    for (Policy policy : treeSetPolicies) {
        if (policy.getExpiryDate().before(thresholdDate)) {
            expiringPolicies.add(policy);
        }
    }
    return expiringPolicies;
}

// Get policies by coverage type
public List<Policy> getPoliciesByCoverageType(String coverageType) {
    List<Policy> policies = new ArrayList<>();
    for (Policy policy : hashSetPolicies) {
        if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
            policies.add(policy);
        }
    }
    return policies;
}

// Identify duplicate policies based on policy number
public Set<String> getDuplicatePolicies() {
    Set<String> seenNumbers = new HashSet<>();
    Set<String> duplicates = new HashSet<>();

    for (Policy policy : hashSetPolicies) {
        if (!seenNumbers.add(policy.getPolicyNumber())) {
            duplicates.add(policy.getPolicyNumber());
        }
    }
    return duplicates;
}

// Performance comparison
public void comparePerformance() {
    int totalOperations = 10000;
    List<Policy> samplePolicies = new ArrayList<>();
    Date date = new Date();

    // Generate sample policies
    for (int i = 0; i < totalOperations; i++) {
        samplePolicies.add(new Policy("P" + i, "Holder" + i, date, "Auto", 500.0 + i));
    }

    // Test HashSet
    long startTime = System.nanoTime();
    for (Policy policy : samplePolicies) hashSetPolicies.add(policy);
    long hashSetTime = System.nanoTime() - startTime;

    // Test LinkedHashSet
    startTime = System.nanoTime();
    for (Policy policy : samplePolicies) linkedHashSetPolicies.add(policy);
    long linkedHashSetTime = System.nanoTime() - startTime;

    // Test TreeSet
    startTime = System.nanoTime();
    for (Policy policy : samplePolicies) treeSetPolicies.add(policy);
    long treeSetTime = System.nanoTime() - startTime;

    // Display performance comparison of adding in Sets
    out.println("\n---------Performance Comparison----------");
    out.println("HashSet Time: " + hashSetTime / 1000000 + " ms");
    out.println("LinkedHashSet Time: " + linkedHashSetTime / 1000000 + " ms");
    out.println("TreeSet Time: " + treeSetTime / 1000000 + " ms");
}

public static void main(String[] args) {
    InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

    // Sample policies
    Calendar cal = Calendar.getInstance();
    cal.set(2024, Calendar.AUGUST, 10);
    Policy p1 = new Policy("P011", "Priyansh", cal.getTime(), "Auto", 1200.50);

    cal.set(2024, Calendar.JULY, 25);
    Policy p2 = new Policy("P012", "Dev", cal.getTime(), "Home", 879.75);

    cal.set(2025, Calendar.JANUARY, 5);
    Policy p3 = new Policy("P013", "Jack", cal.getTime(), "Auto", 950.00);

    cal.set(2024, Calendar.JULY, 30);
    Policy p4 = new Policy("P014", "Gautam", cal.getTime(), "Health", 1129.25);

    // Adding policies
    system.addPolicy(p1);
    system.addPolicy(p2);
    system.addPolicy(p3);
    system.addPolicy(p4);

    // Display all policies
    system.displayAllPolicies();

    // Retrieve policies expiring soon
    out.println("\nPolicies Expiring Soon--------");
    system.getExpiringSoonPolicies().forEach(out::println);

    // Retrieve policies by coverage type
    out.println("\nHealth Insurance Policies---------");
    system.getPoliciesByCoverageType("Health").forEach(out::println);

    // Find duplicate policies
    out.println("\nDuplicate Policy Numbers----------");
    out.println(system.getDuplicatePolicies());

    // Compare performance
    system.comparePerformance();
    }
}
