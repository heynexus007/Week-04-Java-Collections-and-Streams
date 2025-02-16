package javastreams.buffered_streams;
import java.io.*;
import static java.lang.System.*;
public class ReadUserInput {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("user_data.txt")) {

            out.print("Enter your name : ");
            String name = reader.readLine();
            out.print("Enter your age : ");
            int age = Integer.parseInt(reader.readLine());
            out.print("Enter your favorite programming language : ");
            String language = reader.readLine();

            writer.write("Name : " + name + "\nAge : " + age + "\nLanguage : " + language);
            out.println("Data is saved successfully!!!!");

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
