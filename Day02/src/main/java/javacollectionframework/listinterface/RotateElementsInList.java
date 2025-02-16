package javacollectionframework.listinterface;

import java.util.*;
import static java.lang.System.*;

public class RotateElementsInList {
    public static List<Integer> rotateList(List<Integer> list, int pos){
        List<Integer> ans=new ArrayList<>();
        for(int i=pos;i<list.size();i++){
            ans.add(list.get(i));
        }
        int i=0;
        while (i<pos){
            ans.add(list.get(i));
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(10,20,30,40,50);
        int position=2;
        out.println(rotateList(list,position));
    }
}
