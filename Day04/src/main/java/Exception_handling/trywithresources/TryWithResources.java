package Exception_handling.trywithresources;

import java.io.*;
import static java.lang.System.*;
public class TryWithResources {
    public static void main(String[] args) {
        File file= new File("info.txt");

        if(file.exists()){
            try(FileReader fReader= new FileReader(file);
                BufferedReader bReader = new BufferedReader(fReader)){

                String fileTxt=bReader.readLine();
                if(fileTxt !=null){
                    out.println(fileTxt);
                }
            } catch (IOException e) {
                out.println("Error reading file!!!");
            }
        }
        else
            out.println("File not exist!!!!");
    }
}
