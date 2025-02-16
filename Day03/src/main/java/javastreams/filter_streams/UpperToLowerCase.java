package javastreams.filter_streams;

import java.io.*;
import static java.lang.System.*;
public class UpperToLowerCase {
    public static void main(String[] args) {
        try (BufferedReader bReader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bWriter = new BufferedWriter(new FileWriter("output.txt"))) {

            String line=null;
            while ((line = bReader.readLine()) != null) {
                bWriter.write(line.toLowerCase());
                bWriter.newLine();
            }

            out.println("Conversion done!!!");

        }
        catch (IOException E) {
            E.printStackTrace();
        }
    }
}
