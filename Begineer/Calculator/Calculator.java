import java.util.Scanner;

public class Calculator {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1, num2, result;
        int choice;

        System.out.println("Welcome to the Java Calculator!");

        do {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Modulus (%)");
            System.out.println("6. Power (^)");
            System.out.println("7. Square Root (√)");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Enter a number between 1-8: ");
                sc.next();
            }
            choice = sc.nextInt();

            switch(choice) {
                case 1 -> {
                    // Addition
                    num1 = getNumber(sc, "Enter first number: ");
                    num2 = getNumber(sc, "Enter second number: ");
                    result = num1 + num2;
                    System.out.println("Result: " + result);
                }
                case 2 -> {
                    // Subtraction
                    num1 = getNumber(sc, "Enter first number: ");
                    num2 = getNumber(sc, "Enter second number: ");
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                }
                case 3 -> {
                    // Multiplication
                    num1 = getNumber(sc, "Enter first number: ");
                    num2 = getNumber(sc, "Enter second number: ");
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                }
                case 4 -> {
                    // Division
                    num1 = getNumber(sc, "Enter numerator: ");
                    num2 = getNumber(sc, "Enter denominator: ");
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("Result: " + result);
                    } else {
                        System.out.println("Error! Division by zero.");
                    }
                }
                case 5 -> {
                    // Modulus
                    num1 = getNumber(sc, "Enter first number: ");
                    num2 = getNumber(sc, "Enter second number: ");
                    result = num1 % num2;
                    System.out.println("Result: " + result);
                }
                case 6 -> {
                    // Power
                    num1 = getNumber(sc, "Enter base number: ");
                    num2 = getNumber(sc, "Enter exponent: ");
                    result = Math.pow(num1, num2);
                    System.out.println("Result: " + result);
                }
                case 7 -> {
                    // Square Root
                    num1 = getNumber(sc, "Enter number: ");
                    if (num1 >= 0) {
                        result = Math.sqrt(num1);
                        System.out.println("Result: " + result);
                    } else {
                        System.out.println("Error! Negative number.");
                    }
                }
                case 8 -> {
                    System.out.println("Exiting calculator. Goodbye!");
                }
                default -> System.out.println("Invalid choice! Please select 1-8.");
            }

        } while (choice != 8);

        sc.close();
    }
    public static double getNumber(Scanner sc, String message) {
        double num;
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input! Enter a number: ");
            sc.next();
        }
        num = sc.nextDouble();
        return num;
    }
}