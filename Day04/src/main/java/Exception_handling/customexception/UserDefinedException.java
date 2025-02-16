package Exception_handling.customexception;

import java.util.Scanner;
import static java.lang.System.*;
// Creating custom exception
class InvalidAgeException extends Exception{
    InvalidAgeException(){
        super("Age must be 18 or above");
    }
}
public class UserDefinedException {
    // method for validate age
    public static void validateAge(int age) throws InvalidAgeException{
        //if age is less than 18 it throws InvalidAgeException
        if(age<18){
            throw new InvalidAgeException();
        }
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        out.print("Enter Age : ");
        int age=input.nextInt();

        try{
            validateAge(age);
            out.println("Access granted!!!");
        }
        // Catching exception
        catch (InvalidAgeException e){
            out.println("InvalidAgeException ");
        }
    }
}
