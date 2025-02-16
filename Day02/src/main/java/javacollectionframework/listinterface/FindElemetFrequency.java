package javacollectionframework.listinterface;

import java.util.*;
import static java.lang.System.*;

public class FindElemetFrequency {
    // Function for getting frequencies in HashMap
    public static Map<String,Integer> getFrequencies(List<String> arr){
        HashMap<String,Integer> hMap=new HashMap<>();
        for(String e: arr){
            // if element exist (+1), otherwise (defaultValue+1)
            hMap.put(e,hMap.getOrDefault(e,0)+1);
        }

        return hMap;
    }
    public static void main(String[] args) {
        List<String> list=Arrays.asList("apple", "banana", "apple", "orange");
        //Displaying elements in HashMap with Frequencies
        out.println(getFrequencies(list));
    }
}
