package com.bilaal.library;
import com.bilaal.library.model.Book;
import com.bilaal.library.model.Member;
import com.bilaal.library.service.BookNotAvailableException;
import com.bilaal.library.service.LibraryService;
import com.bilaal.library.service.MaxBooksExceededException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryService libraryService = new LibraryService();
                boolean running = true;
        while (running) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book by Title");
            System.out.println("6. List All Books");
            System.out.println("7. List All Members");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Total Copies: ");
                    int totalCopies = Integer.parseInt(scanner.nextLine());
                    Book newBook = new Book(bookId, isbn, title, author, genre, totalCopies);
                    libraryService.addBook(newBook);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    Member newMember = new Member(memberId, name, email, phoneNumber);
                    libraryService.addMember(newMember);
                    System.out.println("Member added successfully!");
                    break;
                case 3:
                    System.out.print("Enter Member ID: ");
                    String borrowMemberId = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    String borrowBookId = scanner.nextLine();
                    try {
                        libraryService.borrowBook(borrowMemberId, borrowBookId);
                        System.out.println("Book borrowed successfully!");
                    } catch (BookNotAvailableException | MaxBooksExceededException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter Member ID: ");
                    String returnMemberId = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    String returnBookId = scanner.nextLine();
                    libraryService.returnBook(returnMemberId, returnBookId);
                    System.out.println("Book returned successfully!");
                    break;
                case 5:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> searchResults = libraryService.searchBookByTitle(searchTitle);
                    if (searchResults.isEmpty()) {
                        System.out.println("No books found with that title.");
                    } else {
                        for (Book b : searchResults) {
                            System.out.println(b);
                        }
                    }
                    break;
                case 6:
                    List<Book> allBooks = libraryService.getAllBooks();
                    if (allBooks.isEmpty()) {
                        System.out.println("No books in the library yet.");
                    } else {
                        for (Book b : allBooks) {
                            System.out.println(b);
                        }
                    }
                    break;
                case 7:
                    List<Member> allMembers = libraryService.getAllMembers();
                    if (allMembers.isEmpty()) {
                        System.out.println("No members registered yet.");
                    } else {
                        for (Member m : allMembers) {
                            System.out.println(m);
                        }
                    }
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}                    