package com.bookstore.backend.exceptions;

public class AuthorCouldNotFindException extends RuntimeException{
    public AuthorCouldNotFindException(String message){
        super(message);
    }
}
