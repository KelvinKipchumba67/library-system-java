import java.util.Scanner;// this allows capturing of input through the terminal
import java.util.ArrayList;//resizable array implementation, it allows for dynamic storage and manipulation of elements

class Book {
    private String bookId;// private is an access specifier similar to public there main purpose is to
    // define visibility and scope
    private String title;
    private String author;
    private int yearPublished;

    public Book(String bookId, String title, String author, int yearPublished) {
        this.bookId = bookId;// this keyword is a reference variable that refers to the class variable(Book)
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    } /*
       * this is a constructor which is used to initialize the object/ create an
       * instance of the class which is basically an object
       */

    // Getters and Setters are methods used to access and modify private fields of a
    // class
    /*
     * getters are used to return the value of a private field and the get keyword
     * followed by the field name while the setters are used to update or set the
     * value of a private field and the keyword here is set with the same naming
     * convention as get. The reason for using getters and setter is mainly for data
     * validation, encapsulation and security, flexibility and maintainability and
     * additional logic
     */
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

    @Override // used to indicate the a method from a subclass is intented to override a
              // method in a superclass.
    public String toString() {
        return "ID: " + studentNo + " | Name: " + name + " | Year: " + yearOfStudy +
                " | Books Borrowed: " + borrowedBooks.size();
    }
}

public class LibrarySystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    /*
     * to take input from the console we use the scanner package, and to use the
     * package we must create a Scanner object to be able to input everytime, to
     * avoid having multiple instances of the Scanner object the above line of code
     * creates an instance that is reused throughout the program
     * it is private because it will only be used within the library class
     */

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n Library System");
            System.out.println("1. Add Book\n2. Add Student\n3. Search Book\n4. Search Student\n5. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();// nextint is a scanner method that reads an integer
            scanner.nextLine(); // consume newline, this reads a line text

            switch (choice) {
                case 1 -> addBook();
                case 2 -> addStudent();
                case 3 -> searchBook();
                case 4 -> searchStudent();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }// here I am using the switch control structure handle different operations that
     // a user inputs from the terminal when the program runs

    /*
     * public static void main(String[] args) is a mandatory part of every java
     * program, is the entry point of a java application, the java virtual machine
     * looks for this exact method to start excuting a program
     * System.out.println prints the text on the terminal line by line
     * System.out.print does the same thing except it does not start on a new line
     */
    private static void addBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        for (Book b : books) {
            if (b.getBookId().equalsIgnoreCase(id)) {
                System.out.println("Error: Book ID already exists!");
                return;
            }
        } // this is a for loop with an if statement that esnures that before a book is
          // added the bookid is not in the existing list this avoids duplication.
          // equalsIgnoreCase is method that compares two strings while ignoring whether
          // it is lowercase or upper
        System.out.print("Title: ");
        String title = scanner.nextLine();// this as I had said reads an entire line including spaces
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
        } // again here we are using for loop and if statement to avoid duplication
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
        scanner.nextLine();// this consumes the newline left over by nextInt method which stops reading at
                           // the first non-integer character
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
    /*
     * b represents every book in the array list, so if lets say you pick to search
     * a book by its id which is where the type==1 the getBookId method is called so
     * what happens is, the if statement with the help of the for each loop tries to
     * find the id that matches what you entered if there is none the program
     * returns no book found and the same applies if you search by the book name
     * that is why we have an or operator
     */

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
        } // this method works similarly to the searchBook method
        System.out.println("No student found.");
    }
}