package com.bilaal.library.service;

import com.bilaal.library.model.Book;
import com.bilaal.library.model.Member;
import java.util.HashMap;
import java.util.Map;

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
}
