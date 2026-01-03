import java.util.Scanner;

public class BankingSystem {

    private static double balance = 0.0;

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=== Simple Banking System ===");

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Enter a number (1-4): ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> deposit(sc);
                case 2 -> withdraw(sc);
                case 3 -> checkBalance();
                case 4 -> System.out.println("Thank you for using the Banking System!");
                default -> System.out.println("Invalid choice! Please select 1-4.");
            }

        } while (choice != 4);

        sc.close();
    }

    private static void deposit(Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid amount! Enter a number: ");
            sc.next();
        }
        double amount = sc.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Rs. " + amount + " deposited successfully.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    private static void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid amount! Enter a number: ");
            sc.next();
        }
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Rs. " + amount + " withdrawn successfully.");
        }
    }

    private static void checkBalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }
}
