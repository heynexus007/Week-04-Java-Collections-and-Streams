package javacollectionframework.queueinterface;
import java.util.*;
import static java.lang.System.*;
public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Remove all elements and push them in stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Pop elements from the stack and add back into the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        out.println("Original Queue : " + queue);
        reverseQueue(queue);
        out.println("Reversed Queue : " + queue);
    }
}
