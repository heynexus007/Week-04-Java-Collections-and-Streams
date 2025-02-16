package javacollectionframework.setinterface;

import java.util.*;
import static java.lang.System.*;

public class ConvertIntoSortedList {
    // Method to convert Set to SortedList
    public static Set<Integer> convertSetToSortedList(Set<Integer> set){
        TreeSet<Integer> sortedList=new TreeSet<>(set);

        return sortedList;
    }
    public static void main(String[] args) {
        Set<Integer> set =new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);

        // Calling method
        out.println("Sorted List : "+convertSetToSortedList(set));
    }
}
