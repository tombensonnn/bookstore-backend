package com.bookstore.backend.exceptions;

public class BookCouldNotFindException extends RuntimeException{
    public BookCouldNotFindException(String message) {
        super(message);
    }
}
