package javastreams.file_handling;
import java.io.*;
import static java.lang.System.*;
public class FileHandling {
    public static void main(String[] args) {
        File source = new File("source.txt");
        File destination = new File("destination.txt");

        // Check if source file exists
        if (!source.exists()) {
            out.println("Source file does not exist!!!");
            return;
        }

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            out.println("File copied successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
