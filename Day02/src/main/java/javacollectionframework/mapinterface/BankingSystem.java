package javacollectionframework.mapinterface;
import java.util.*;
import static java.lang.System.*;
public class BankingSystem {
    private HashMap<String, Double> bankAccounts = new HashMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void createAccount(String accountNumber, double balance) {
        bankAccounts.put(accountNumber, balance);
    }

    public void requestWithdrawal(String accountNumber) {
        if (bankAccounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
        else {
            out.println("Invalid account number!!!");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String account = withdrawalQueue.poll();
            out.println("Processing withdrawal for : " + account);
        }
    }

    public void displaySortedByBalance() {
        TreeMap<Double, String> sortedAccounts = new TreeMap<>();
        for (Map.Entry<String, Double> entry : bankAccounts.entrySet()) {
            sortedAccounts.put(entry.getValue(), entry.getKey());
        }
        out.println("Accounts sorted by balance : " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount("123", 4000);
        bank.createAccount("456", 2000);
        bank.createAccount("789", 7000);

        bank.requestWithdrawal("123");
        bank.requestWithdrawal("456");

        bank.processWithdrawals();
        bank.displaySortedByBalance();
    }
}
