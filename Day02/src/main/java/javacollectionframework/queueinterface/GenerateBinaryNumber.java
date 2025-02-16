package javacollectionframework.queueinterface;

import java.util.*;
import static java.lang.System.*;
public class GenerateBinaryNumber {
    public static String generateBinaryNumbers(int n) {
        String binary=Integer.toBinaryString(n);

        return binary;
    }
    public static Queue<String> addInQueue(int n){
        Queue<String> queue=new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.add(generateBinaryNumbers(i));
        }
        return queue;
    }
    public static void main(String[] args) {
        int n = 5;
        out.println("Binary Queue : "+addInQueue(n));

    }
}
