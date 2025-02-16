package javacollectionframework.setinterface;

import java.util.*;
import static java.lang.System.*;

public class FindingSubsets {
    // Method to check subset or not
    public static boolean isSubset(Set<Integer>s1, Set<Integer>s2){
        if(!s2.containsAll(s1)) return false;

        return true;
    }
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>();
        set1.add(2);
        set1.add(3);
        Set<Integer> set2=new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Calling method
        out.println("Is 'Set1' Subset of 'Set2'? "+isSubset(set1,set2));
    }
}
