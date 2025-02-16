package javacollectionframework.queueinterface;

import java.util.*;
import static java.lang.System.*;
public class CircularBufferSimulation {
    private Deque<Integer> buffer;
    private int maxSize;

    // Constructor to initialize the circular buffer with a fixed size
    public CircularBufferSimulation(int size) {
        this.maxSize = size;
        this.buffer = new ArrayDeque<>(size);
    }

    // Method to insert an element into the buffer
    public void enqueue(int value) {
        if (buffer.size() == maxSize) {
            buffer.pollFirst(); // Remove the oldest element (from front)
        }
        buffer.addLast(value); // Add new element at the rear
    }

    // Method to display buffer elements in order
    public void display() {
        out.println("Buffer : " + buffer);
    }

    public static void main(String[] args) {
        CircularBufferSimulation buffer = new CircularBufferSimulation(3);

        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.display();

        // Overwrites the oldest element (1)
        buffer.enqueue(4);
        buffer.display();

        // Overwrites the oldest element (2)
        buffer.enqueue(5);
        buffer.display();
    }
}