package javacollectionframework.listinterface;

import java.util.*;
import static java.lang.System.*;

public class RemoveDuplicates {
    public static void removeDuplicatesPreseveOrder(List<Integer> list){
        LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<>();
        for(int i: list){
            linkedHashSet.add(i);
        }
        out.println(linkedHashSet);
    }
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(3,1,2,2,3,4);
        removeDuplicatesPreseveOrder(list);
    }
}
