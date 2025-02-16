package Exception_handling.checkedexception;

import java.io.*;
public class CompileTimeException {
    public static void main(String[] args) {
        // file Store in File
        File file= new File("data.txt");

        try(FileReader fReader=new FileReader(file);
            BufferedReader bReader=new BufferedReader(fReader)){

            String fileText;
            //If file exists, Printing its content
            if(file.exists()){
                while((fileText=bReader.readLine())!=null){
                    System.out.println(fileText);
                }
            }
            //closing BufferedReader and FileReader
            bReader.close();
            fReader.close();

        }catch(IOException e){
            System.out.println("File not found!!!");
        }
    }
}
