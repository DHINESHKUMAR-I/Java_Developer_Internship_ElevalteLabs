import java.util.ArrayList;

public class Account {

    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    protected ArrayList<String> transactionHistory = new ArrayList<>();

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;

        transactionHistory.add("Account Created with Balance : ₹" + balance);
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Deposit Amount");
            return;
        }

        balance += amount;

        transactionHistory.add("Deposited : ₹" + amount);

        System.out.println("₹" + amount + " Deposited Successfully.");
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance");
            return;
        }

        balance -= amount;

        transactionHistory.add("Withdrawn : ₹" + amount);

        System.out.println("₹" + amount + " Withdrawn Successfully.");
    }

    public void displayBalance() {

        System.out.println("Current Balance : ₹" + balance);
    }

    public void showTransactionHistory() {

        System.out.println("\nTransaction History");

        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void displayAccountDetails() {

        System.out.println("\nAccount Details");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance : ₹" + balance);
    }
}