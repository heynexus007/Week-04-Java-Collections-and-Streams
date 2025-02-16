package javastreams.data_streams;

import java.io.*;
import static java.lang.System.*;
public class DataStreamExample {
    public static void main(String[] args) {
        String fileName = "students.data";

        // Writing student data to a binary file
        try (DataOutputStream outputStreamputS = new DataOutputStream(new FileOutputStream(fileName))) {
            outputStreamputS.writeInt(101);
            outputStreamputS.writeUTF("Rahul");
            outputStreamputS.writeDouble(3.8);

            outputStreamputS.writeInt(102);
            outputStreamputS.writeUTF("Ram");
            outputStreamputS.writeDouble(3.6);

            out.println("Student data is saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading student data from the binary file
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName))) {
            // Check if more data is available
            while (inputStream.available() > 0) {
                int rollNo = inputStream.readInt();
                String name = inputStream.readUTF();
                double gpa = inputStream.readDouble();
                out.println("Roll No : " + rollNo + ", Name : " + name + ", GPA : " + gpa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
