package Exception_handling.banktransactionsystem;

import java.util.*;
import static java.lang.System.*;
// creating Custom exception
class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(){
        super("Insufficient balance!!!");
    }
}
public class BankTransactionSystem {
    public static void withdraw(double amount, double withdrawAmount) throws InsufficientBalanceException{
        if(withdrawAmount>amount){
            throw new InsufficientBalanceException();
        }
    }
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    out.print("Enter Bank Balance : ");
    double amount=input.nextDouble();

    out.print("Enter Withdraw amount : ");
    double withdrawAmount=input.nextDouble();

        try{
            try{
                if(amount<0){
                    throw new IllegalArgumentException();
                }
                else if(withdrawAmount<amount && amount>0)
                    out.println("Withdrawal successful, new balance : "+(amount-withdrawAmount));
            } catch (IllegalArgumentException e) {
                out.println("Invalid amount!!!");
            }
            withdraw(amount,withdrawAmount);
        }catch (InsufficientBalanceException e) {
            out.println("Insufficient balance!!!");
        }


    }
}
