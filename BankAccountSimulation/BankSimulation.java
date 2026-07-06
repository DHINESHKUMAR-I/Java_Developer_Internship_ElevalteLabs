import java.util.Scanner;

public class BankSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== BANK ACCOUNT SIMULATION =====");

        System.out.println("Select Account Type");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter Choice : ");

        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Number : ");
        String accNo = sc.nextLine();

        System.out.print("Enter Account Holder Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance : ");
        double balance = sc.nextDouble();

        Account account;

        if (choice == 1) {
            account = new SavingsAccount(accNo, name, balance);
        } else {
            account = new CurrentAccount(accNo, name, balance);
        }

        int option;

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");

            option = sc.nextInt();

            switch (option) {

                case 1:
                    System.out.print("Enter Deposit Amount : ");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter Withdrawal Amount : ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    account.displayAccountDetails();
                    break;

                case 5:
                    account.showTransactionHistory();
                    break;

                case 6:
                    System.out.println("Thank You for Banking!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (option != 6);

        sc.close();
    }
}