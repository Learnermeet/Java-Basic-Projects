import java.util.Scanner;

public class NumberSystemConverter {

    @SuppressWarnings({"UnnecessaryTemporaryOnConversionFromString", "ConvertToTryWithResources"})
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nNumber System Converter.");
            System.out.println("1. Binary to Decimal");
            System.out.println("2. Decimal to Binary");
            System.out.println("3. Decimal to Octal");
            System.out.println("4. Decimal to Hexadecimal");
            System.out.println("5. Octal to Decimal");
            System.out.println("6. Hexadecimal to Decimal");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Binary number: ");
                    String binary = sc.next();
                    System.out.println("Decimal: " + Integer.parseInt(binary, 2));
                }

                case 2 -> {
                    System.out.print("Enter Decimal number: ");
                    int decimal1 = sc.nextInt();
                    System.out.println("Binary: " + Integer.toBinaryString(decimal1));
                }

                case 3 -> {
                    System.out.print("Enter Decimal number: ");
                    int decimal2 = sc.nextInt();
                    System.out.println("Octal: " + Integer.toOctalString(decimal2));
                }

                case 4 -> {
                    System.out.print("Enter Decimal number: ");
                    int decimal3 = sc.nextInt();
                    System.out.println("Hexadecimal: " + Integer.toHexString(decimal3).toUpperCase());
                }

                case 5 -> {
                    System.out.print("Enter Octal number: ");
                    String octal = sc.next();
                    System.out.println("Decimal: " + Integer.parseInt(octal, 8));
                }

                case 6 -> {
                    System.out.print("Enter Hexadecimal number: ");
                    String hex = sc.next();
                    System.out.println("Decimal: " + Integer.parseInt(hex, 16));
                }

                case 0 -> System.out.println("Exiting Number System Converter.");

                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);
        sc.close();
    }
}