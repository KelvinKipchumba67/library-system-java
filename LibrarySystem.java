import java.util.Scanner;
import java.util.ArrayList;

class Book {
    private String bookId;
    private String title;
    private String author;
    private int yearPublished;

    public Book(String bookId, String title, String author, int yearPublished) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    // Getters and Setters
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "ID: " + bookId + " | Title: " + title + " | Author: " + author + " (" + yearPublished + ")";
    }
}

class Student {
    private String studentNo;
    private String name;
    private int yearOfStudy;
    private ArrayList<Book> borrowedBooks;

    public Student(String studentNo, String name, int yearOfStudy) {
        this.studentNo = studentNo;
        this.name = name;
        this.yearOfStudy = yearOfStudy;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and Setters
    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() < 3) {
            borrowedBooks.add(book);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ID: " + studentNo + " | Name: " + name + " | Year: " + yearOfStudy +
                " | Books Borrowed: " + borrowedBooks.size();
    }
}

public class LibrarySystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- COSC 223 Library System ---");
            System.out.println("1. Add Book\n2. Add Student\n3. Search Book\n4. Search Student\n5. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> addStudent();
                case 3 -> searchBook();
                case 4 -> searchStudent();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        for (Book b : books) {
            if (b.getBookId().equalsIgnoreCase(id)) {
                System.out.println("Error: Book ID already exists!");
                return;
            }
        }
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        books.add(new Book(id, title, author, year));
        System.out.println("Book added successfully.");
    }

    private static void addStudent() {
        System.out.print("Enter Student Number: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getStudentNo().equalsIgnoreCase(id)) {
                System.out.println("Error: Student ID already exists!");
                return;
            }
        }
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Year of Study: ");
        int year = scanner.nextInt();
        students.add(new Student(id, name, year));
        System.out.println("Student added successfully.");
    }

    private static void searchBook() {
        System.out.print("Search by (1) ID or (2) Name: ");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter search term: ");
        String query = scanner.nextLine();

        for (Book b : books) {
            if ((type == 1 && b.getBookId().equalsIgnoreCase(query)) ||
                    (type == 2 && b.getTitle().equalsIgnoreCase(query))) {
                System.out.println("Result: " + b);
                return;
            }
        }
        System.out.println("No book found.");
    }

    private static void searchStudent() {
        System.out.print("Search by (1) ID or (2) Name: ");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter search term: ");
        String query = scanner.nextLine();

        for (Student s : students) {
            if ((type == 1 && s.getStudentNo().equalsIgnoreCase(query)) ||
                    (type == 2 && s.getName().equalsIgnoreCase(query))) {
                System.out.println("Result: " + s);
                return;
            }
        }
        System.out.println("No student found.");
    }
}