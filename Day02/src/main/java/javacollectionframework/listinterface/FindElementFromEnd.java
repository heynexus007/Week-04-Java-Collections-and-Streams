package javacollectionframework.listinterface;

import java.util.*;

public class FindElementFromEnd {
    public static Character getElement(LinkedList<Character> list, int N){
        ListIterator<Character> first = list.listIterator();
        ListIterator<Character> second = list.listIterator();

        // Move the first pointer N steps ahead
        int count = 0;
        while (count < N && first.hasNext()) {
            first.next();
            count++;
        }

        // If N is greater than the size of the list
        if (count < N) {
            return null;
        }

        // Move both pointers until the first reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        // The second pointer now points to the Nth element from the end
        return second.next();
    }
    public static void main(String[] args) {
        LinkedList<Character> ll=new LinkedList<>();
        int pos=2;
        ll.add('A');
        ll.add('B');
        ll.add('C');
        ll.add('D');
        ll.add('E');

        //Calling method and Storing the result
        Character ans=getElement(ll,pos);
        if (ans != null) {
            System.out.println("Nth element from the end: " + ans);
        } else {
            System.out.println("Invalid N value.");
        }
    }
}
