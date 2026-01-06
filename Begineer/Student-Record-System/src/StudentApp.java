import java.io.*;
import java.util.*;

public class StudentApp {

    static ArrayList<Student> students = new ArrayList<>();
    static final String DATA_FOLDER = "Begineer/Student-Record-System/data";
    static final String STUDENT_FILE = DATA_FOLDER + "/students.txt";

    public static void main(String[] args) {

        // Create data folder if missing
        new File(DATA_FOLDER).mkdirs();

        // check student file exists
        try {
            new File(STUDENT_FILE).createNewFile();
        } catch (IOException e) {
            System.out.println("Error creating students.txt: " + e.getMessage());
        }

        loadStudents();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update CGPA");
            System.out.println("5. Average CGPA");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> viewStudents();
                case 3 -> searchStudent(sc);
                case 4 -> updateCGPA(sc);
                case 5 -> showAverage();
                case 6 -> {
                    saveStudents();
                    System.out.println("Exiting system.");
                }
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    // Load students from file
    static void loadStudents() {
        try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                students.add(new Student(
                        Integer.parseInt(d[0]),
                        d[1],
                        Double.parseDouble(d[2])
                ));
            }
        } catch (IOException e) {
            System.out.println("No existing student data found.");
        }
    }

    // Save students to file
    static void saveStudents() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(STUDENT_FILE))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving students.");
        }
    }

    // Add student
    static void addStudent(Scanner sc) {
        System.out.print("Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Check if ID already exists
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("ID already exists! Try again.");
                return; // stop adding
            }
        }

        System.out.print("Student Name: ");
        String name = sc.nextLine();

        System.out.print("CGPA: ");
        double cgpa = sc.nextDouble();
        sc.nextLine();

        if (cgpa < 0 || cgpa > 10) {
            System.out.println("Invalid CGPA! Must be between 0 and 10.");
            return;
        }
        students.add(new Student(id, name, cgpa));
        System.out.println("Student added successfully!");
    }

    // View all students
    static void viewStudents() {
        System.out.println("\nID | Name | CGPA");
        for (Student s : students) {
            System.out.println(s.getId() + " | " + s.getName() + " | " + s.getCGPA());
        }
    }

    // Search student by ID
    static void searchStudent(Scanner sc) {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        boolean found = false;
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("ID: " + s.getId());
                System.out.println("Name: " + s.getName());
                System.out.println("CGPA: " + s.getCGPA());
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("Student not found.");
    }

    // Update CGPA
    static void updateCGPA(Scanner sc) {
        System.out.print("Enter Student ID to update CGPA: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new CGPA: ");
                double cgpa = sc.nextDouble();
                s.setCGPA(cgpa);
                System.out.println("CGPA updated!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Show average CGPA
    static void showAverage() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        double total = 0;
        for (Student s : students) total += s.getCGPA();
        double avg = total / students.size();
        System.out.printf("Average CGPA: %.2f%n", avg);
    }
}
