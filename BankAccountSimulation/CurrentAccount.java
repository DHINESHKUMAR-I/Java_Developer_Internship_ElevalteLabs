public class CurrentAccount extends Account {

    public CurrentAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) {

        if (amount > balance + 1000) {

            System.out.println("Overdraft Limit Exceeded.");

            return;
        }

        balance -= amount;

        transactionHistory.add("Withdrawn : ₹" + amount);

        System.out.println("₹" + amount + " Withdrawn Successfully.");
    }
}