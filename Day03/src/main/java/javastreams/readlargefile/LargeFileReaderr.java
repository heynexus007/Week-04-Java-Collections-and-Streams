package javastreams.readlargefile;

import java.io.*;
import static java.lang.System.*;

public class LargeFileReaderr {
    public static void main(String[] args) {
        String fileName = "largefile.txt";

        try (BufferedReader bReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bReader.readLine()) != null) {
                // Case in-sensitive check
                if (line.toLowerCase().contains("error")) {
                    out.println(line);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
