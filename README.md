# Library Management System (Java)

A simple, console-based Library Management System built with Java. This project was developed to explore object-oriented programming, data structures, and basic record management using Java.

## Overview

The Library Management System provides a menu-driven interface for managing basic library records. It allows users to register books and students, as well as search for existing records.

The project focuses on applying fundamental Java concepts to a practical, real-world scenario.

## Features

- **Book Management:** Add books with unique IDs, titles, authors, and publication years.
- **Student Registration:** Register students using their student numbers, names, and years of study.
- **Book Search:** Search for books using their ID or title.
- **Student Search:** Search for students using their student number or name.
- **Duplicate Prevention:** Prevents registration of books and students with existing IDs.
- **Borrowing Logic:** The Student class includes a borrowing method with a maximum limit of three books per student.

## Technologies Used

- **Java** – Core programming language.
- **ArrayList** – Dynamic storage and management of book and student records.
- **Scanner** – Capturing user input through the terminal.

## Getting Started

### Prerequisites

- Java Development Kit (JDK 14 or later).
- A terminal or command-line interface.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/KelvinKipchumba67/library-system-java.git
   ```

2. Navigate into the project directory:

   ```bash
   cd library-system-java
   ```

3. Compile the Java source file:

   ```bash
   javac LibrarySystem.java
   ```

4. Run the application:

   ```bash
   java LibrarySystem
   ```

## Usage

Once the application starts, a menu will appear:

```text
Library System

1. Add Book
2. Add Student
3. Search Book
4. Search Student
5. Exit

Choice:
```

Select an option by entering its corresponding number and follow the prompts displayed in the terminal.

## Project Structure

```text
library-system-java/
│
├── Book.class
├── LibrarySystem.class
├── LibrarySystem.java
├── Student.class
└── README.md
```

The Java source file contains the three main classes: `Book`, `Student`, and `LibrarySystem`.

The `.class` files are compiled Java bytecode generated from the source code.

## Concepts Explored

This project provided practical experience with:

- Object-Oriented Programming (OOP)
- Classes and Objects
- Constructors
- Encapsulation
- Getters and Setters
- ArrayLists
- Loops and Conditional Statements
- Switch Statements
- Methods and Object Interaction
- User Input and Console-Based Applications

## Limitations

- Data is stored in memory and is not retained after the application terminates.
- The borrowing method is implemented in the Student class but is not yet integrated into the main menu.
- The application uses a command-line interface rather than a graphical interface.

## Future Improvements

- Implement book borrowing and returning through the main menu.
- Add persistent storage using files or a database.
- Introduce book availability tracking.
- Add input validation and improved error handling.
- Implement book and student deletion or updating.

---

**Author:** [Kelvin Kipchumba](https://github.com/KelvinKipchumba67)

**Repository:** [library-system-java](https://github.com/KelvinKipchumba67/library-system-java)
