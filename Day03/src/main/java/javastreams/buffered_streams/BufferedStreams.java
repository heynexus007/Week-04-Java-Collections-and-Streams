package javastreams.buffered_streams;

import java.io.*;
import static java.lang.System.*;
public class BufferedStreams {
    private static void copyUsingBufferedStream(File source, File destination) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyUsingUnbufferedStream(File source, File destination) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File source = new File("largefile.txt");
        File dBuffered = new File("buffered.txt");
        File dUnbuffered = new File("unbuffered.txt");

        // Copy using buffered streams
        long startTime = System.nanoTime();
        copyUsingBufferedStream(source, dBuffered);
        long bufferedTime = System.nanoTime() - startTime;

        // Copy using unbuffered streams
        startTime = System.nanoTime();
        copyUsingUnbufferedStream(source, dUnbuffered);
        long unbufferedTime = System.nanoTime() - startTime;

        out.println("Buffered copy time : " + bufferedTime / 1e6 + " ms");
        out.println("Unbuffered copy time : " + unbufferedTime / 1e6 + " ms");
    }
}
