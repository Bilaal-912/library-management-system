package com.bilaal.library.service;

public class BookNotAvailableException extends Exception{
    public BookNotAvailableException(String message){
        super(message);
    }
}