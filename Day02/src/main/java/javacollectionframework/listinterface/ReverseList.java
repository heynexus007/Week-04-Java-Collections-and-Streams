package javacollectionframework.listinterface;

import java.util.*;
import static java.lang.System.*;

public class ReverseList {
    //Function to reverse a ArrayList
    public static List<Integer> reverseArraylist(List<Integer> list){
        int p=0;
        int q=list.size()-1;
        while(p<q){
                Integer temp = list.get(p);
                list.set(p, list.get(q));
                list.set(q, temp);
                p++;
                q--;
        }
        return list;
    }

    // Function to reverse a LinkedList
    public static List<Integer> reverseLinkedlist(LinkedList<Integer> linkedList){
        LinkedList<Integer> newLL=new LinkedList<>();
        for(int i=linkedList.size()-1;i>=0;i--){
            newLL.addLast(linkedList.pollLast());
        }

        return newLL;
    }
    public static void main(String[] args) {
        // Given ArrayList or List
        List<Integer> givenList= Arrays.asList(1,2,3,4,5);
        // Displaying ArrayList Output
        out.println("Original ArrayList : "+givenList);
        out.println("ArrayList After Reversing : "+reverseArraylist(givenList));

        LinkedList<Integer> ll=new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        // Displaying LinkedList Output
        out.println("Original LinkedList : " +ll);
        out.println("LinkedList After Reversing : " +reverseLinkedlist(ll));
    }
}
