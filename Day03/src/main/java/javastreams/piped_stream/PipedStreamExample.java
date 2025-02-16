package javastreams.piped_stream;

//Dont Paste file
import java.io.*;
class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer!";
            pos.write(message.getBytes());
            pos.close();  // Close stream after writing
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            int data;
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }
            pis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class PipedStreamExample {
    public static void main(String[] args) throws IOException {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        // Create writer and reader threads
        new WriterThread(pos).start();
        new ReaderThread(pis).start();
    }
}
