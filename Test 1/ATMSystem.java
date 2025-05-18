import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Atm atm = new Atm();

        atm.addAccount(new Account("1", "Federico", 500));
        atm.addAccount(new Account("2", "Filippo", 2200));
        atm.addAccount(new Account("3", "Clara", 30000));

        System.out.println("=== Welcome to Console ATM System ===");

        System.out.print("Enter your account number: ");
        String accNumber = scanner.nextLine();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        Account userAccount = atm.authenticate(accNumber, name);

        if (userAccount == null) {
            System.out.println(" Authentication failed. Account not found.");
            return;
        }

        System.out.println("Login successful. Welcome, " + userAccount.getAccountHolderName());

        int choice;
        do {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance: $" + userAccount.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double dep = scanner.nextDouble();
                    userAccount.deposit(dep);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double with = scanner.nextDouble();
                    userAccount.withdraw(with);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
