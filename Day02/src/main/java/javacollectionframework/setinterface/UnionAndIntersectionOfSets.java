package javacollectionframework.setinterface;

import java.util.*;
import static java.lang.System.*;
public class UnionAndIntersectionOfSets {
    // Method for getting Union of two sets
    public static Set<Integer> getUnion(Set<Integer>s1, Set<Integer>s2){
        Set<Integer> unionSet= new HashSet<>(s1);
        unionSet.addAll(s2);

        return unionSet;
    }

    // Method for getting Intersection of two sets
    public static Set<Integer> getIntersection(Set<Integer>s1, Set<Integer>s2){
        Set<Integer> intersectionSet= new HashSet<>(s1);
        intersectionSet.retainAll(s2);

        return intersectionSet;
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

        out.println("Union of Sets : " +getUnion(set1,set2));
        out.println("Intersection of Sets : " +getIntersection(set1,set2));
    }
}
