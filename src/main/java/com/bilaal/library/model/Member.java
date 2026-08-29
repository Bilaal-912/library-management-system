package com.bilaal.library.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private String email;
    private String phoneNumber;
    private List<String> borrowedBookIds;

    public Member(String memberId, String name, String email, String phoneNumber) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowedBookIds = new ArrayList<>();
    }
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public List<String> getBorrowedBookIds() {
        return borrowedBookIds;
    }

    public void addBorrowedBook(String bookId) {
        borrowedBookIds.add(bookId);
    }

    public void removeBorrowedBook(String bookId) {
        borrowedBookIds.remove(bookId);
    }
    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", borrowedBookIds=" + borrowedBookIds +
                '}';
    }
}
