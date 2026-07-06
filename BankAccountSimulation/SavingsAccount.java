public class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) {

        if (balance - amount < 500) {

            System.out.println("Minimum Balance of ₹500 must be maintained.");

            return;
        }

        super.withdraw(amount);
    }
}