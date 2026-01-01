import java.util.Scanner;

public class TemperatureConverter {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        double temp, result;

        System.out.println("Temperature Converter");

        do {
            System.out.println("\nChoose Conversion:");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Celsius to Kelvin");
            System.out.println("4. Kelvin to Celsius");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Celsius: ");
                    temp = sc.nextDouble();
                    result = (temp * 9 / 5) + 32;
                    System.out.printf("Fahrenheit: %.2f%n", result);
                }

                case 2 -> {
                    System.out.print("Enter Fahrenheit: ");
                    temp = sc.nextDouble();
                    result = (temp - 32) * 5 / 9;
                    System.out.printf("Celsius: %.2f%n", result);
                }

                case 3 -> {
                    System.out.print("Enter Celsius: ");
                    temp = sc.nextDouble();
                    result = temp + 273.15;
                    System.out.printf("Kelvin: %.2f%n", result);
                }

                case 4 -> {
                    System.out.print("Enter Kelvin: ");
                    temp = sc.nextDouble();
                    result = temp - 273.15;
                    System.out.printf("Celsius: %.2f%n", result);
                }

                case 5 -> System.out.println("Thank you for using Temperature Converter!");

                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}