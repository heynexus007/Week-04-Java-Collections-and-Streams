package javacollectionframework.setinterface;

import java.util.*;
import static java.lang.System.*;

public class TwoSetAreEqual {
    public static boolean areSetEquals(Set<Integer> s1, Set<Integer> s2){
        return s2.equals(s1);
    }
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2=new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        out.println("Are the sets equals? " +areSetEquals(set1,set2));
    }
}
