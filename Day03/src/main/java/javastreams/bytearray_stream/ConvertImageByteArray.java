package javastreams.bytearray_stream;
import java.io.*;
import static java.lang.System.*;

public class ConvertImageByteArray {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.jpg");
        File outputFile = new File("output.jpg");

        try (FileInputStream fis = new FileInputStream(inputFile);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageData = baos.toByteArray();

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(imageData);
            }

            out.println("Image copied successfully!");
        }
    }
}
