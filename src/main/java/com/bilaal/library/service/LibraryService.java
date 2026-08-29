package com.bilaal.library.service;

import com.bilaal.library.model.Book;
import com.bilaal.library.model.Member;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
public class LibraryService {
    private Map<String, Book> books;
    private Map<String, Member> members;
    public LibraryService() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
    }
    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }
    public void borrowBook(String memberId, String bookId) throws BookNotAvailableException, MaxBooksExceededException {
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        if(book.getAvailableCopies() == 0) {
            throw new BookNotAvailableException("Book '" + book.getTitle() + "' has no available copies.");
        }
        if(member.getBorrowedBookIds().size() == 3) {
            throw new MaxBooksExceededException("Member '" + member.getName() + "' has already borrowed the maximum of 3 books.");
        }
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        member.addBorrowedBook(bookId);
    }
    public void returnBook(String memberId, String bookId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        book.setAvailableCopies(book.getAvailableCopies()+1);
        member.removeBorrowedBook(bookId);
    }
    public List<Book> searchBookByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                results.add(book);
            }
        }
        return results;
    }
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public List<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }
}

