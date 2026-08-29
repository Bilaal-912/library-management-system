package com.bilaal.library.service;

public class MaxBooksExceededException extends Exception{
    public MaxBooksExceededException(String message){
        super(message);
    }
}