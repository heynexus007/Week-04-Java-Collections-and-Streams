package javacollectionframework.setinterface;

import java.util.*;
import static java.lang.System.*;

public class FindSymmetricDifference {
    // Method for getting Union of two sets
    public static Set<Integer> getSymmetricDifference(Set<Integer>s1, Set<Integer>s2){
        Set<Integer> symmetricDiff= new HashSet<>(s1);
        Set<Integer> intersection = new HashSet<>(s1);
        symmetricDiff.addAll(s2);   // adding Set2 to symmetricDiff Set
        intersection.retainAll(s2); // finding intersection
        // Removing all intersection from symmetricDiff Set
        symmetricDiff.removeAll(intersection);

        return symmetricDiff;
    }
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2=new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        out.println("Symmetric Difference : " +getSymmetricDifference(set1,set2));
    }
}
