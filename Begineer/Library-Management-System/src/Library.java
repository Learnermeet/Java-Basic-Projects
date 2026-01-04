import java.io.*;
import java.util.*;

public class Library {

    static ArrayList<Book> books = new ArrayList<>();
    static final String DATA_FOLDER = "Begineer/Library-Management-System/data";
    static final String BOOK_FILE = DATA_FOLDER + "/books.txt";
    static final String ISSUE_FILE = DATA_FOLDER + "/issued.txt";


    public static void main(String[] args) {

        new File(DATA_FOLDER).mkdirs();

        try {
            new File(BOOK_FILE).createNewFile();
            new File(ISSUE_FILE).createNewFile();
        } catch (IOException e) {
            System.out.println("Error creating data files: " + e.getMessage());
        }
        loadBooks();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Book Count");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addBook(sc);
                case 2 -> viewBooks();
                case 3 -> searchBook(sc);
                case 4 -> issueBook(sc);
                case 5 -> returnBook(sc);
                case 6 -> showCount();
                case 7 -> {
                    saveBooks();
                    System.out.println("Library closed.");
                }
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 7);
    }

    // Load books from books.txt
    static void loadBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader(BOOK_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                books.add(new Book(
                        Integer.parseInt(d[0]),
                        d[1],
                        Boolean.parseBoolean(d[2])
                ));
            }
        } catch (IOException e) {
            System.out.println("No existing book data found.");
        }
    }

    // Save books to books.txt
    static void saveBooks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOK_FILE))) {
            for (Book b : books) {
                bw.write(b.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books.");
        }
    }

    // Add Book
    static void addBook(Scanner sc) {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Book Title: ");
        String title = sc.nextLine();

        books.add(new Book(id, title, false));
        System.out.println("Book added successfully!");
    }

    // View Books
    static void viewBooks() {
        System.out.println("\nID | Title | Status");
        for (Book b : books) {
            System.out.println(
                b.getId() + " | " + b.getTitle() + " | " +
                (b.isIssued() ? "Issued" : "Available")
            );
        }
    }

    // Search Book
    static void searchBook(Scanner sc) {
        System.out.print("Enter book title to search: ");
        String search = sc.nextLine().toLowerCase();

        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(search)) {
                System.out.println(b.getId() + " | " + b.getTitle());
                found = true;
            }
        }

        if (!found)
            System.out.println("Book not found.");
    }

    // Issue Book
    static void issueBook(Scanner sc) {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.getId() == id && !b.isIssued()) {
                b.setIssued(true);
                saveIssuedBook(b);
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    // Return Book
    static void returnBook(Scanner sc) {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.getId() == id && b.isIssued()) {
                b.setIssued(false);
                removeIssuedBook(id);
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Invalid return.");
    }

    // Save issued book to issued.txt
    static void saveIssuedBook(Book b) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ISSUE_FILE, true))) {
            bw.write(b.getId() + "," + b.getTitle());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving issued book.");
        }
    }

    // Remove returned book from issued.txt
    static void removeIssuedBook(int bookId) {
        File input = new File(ISSUE_FILE);
        File temp = new File(DATA_FOLDER + "/temp_issued.txt");

        try (
            BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) != bookId) {
                    bw.write(line);
                    bw.newLine();
                }
            }
            input.delete();
            temp.renameTo(input);
        } catch (IOException e) {
            System.out.println("Error updating issued file.");
        }
    }

    // Book Count
    static void showCount() {
        int issued = 0;
        for (Book b : books)
            if (b.isIssued()) issued++;

        System.out.println("Total Books: " + books.size());
        System.out.println("Issued: " + issued);
        System.out.println("Available: " + (books.size() - issued));
    }
}
