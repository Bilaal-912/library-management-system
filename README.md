# Library Management System

A console-based Library Management System built in pure Java, demonstrating core OOP principles, collections, custom exceptions, and clean separation between data models and business logic — no frameworks.

## Features
- Add books and members
- Borrow and return books, with real-time tracking of available copies
- Enforced business rules via custom checked exceptions:
  - `BookNotAvailableException` — thrown when a book has zero available copies
  - `MaxBooksExceededException` — thrown when a member already has 3 books borrowed
- Search books by title (case-insensitive)
- List all books and all members
- Simple console menu, built with `Scanner` and a `switch` statement

## Design Highlights
- **Encapsulation**: fields like `availableCopies` and `borrowedBookIds` are never set directly from outside their class — they're only changed through controlled methods (`borrowBook()`, `returnBook()`, `addBorrowedBook()`), preventing invalid state.
- **Collections**: `HashMap<String, Book>` and `HashMap<String, Member>` for O(1) lookups by ID; `ArrayList` for each member's borrowed books.
- **Custom checked exceptions**: business rule violations (no copies left, borrow limit reached) are modeled as exceptions rather than silent failures or print statements, forcing callers to handle them explicitly.

## Tech Stack
- Java (no external frameworks)
- Collections API (HashMap, ArrayList, List)
- Custom checked exceptions

## How to Run
```bash
javac -d out src/main/java/com/bilaal/library/model/Book.java src/main/java/com/bilaal/library/model/Member.java src/main/java/com/bilaal/library/service/BookNotAvailableException.java src/main/java/com/bilaal/library/service/MaxBooksExceededException.java src/main/java/com/bilaal/library/service/LibraryService.java src/main/java/com/bilaal/library/Main.java
java -cp out com.bilaal.library.Main
```


## Status
✅ Complete

## Author
Bilaal
