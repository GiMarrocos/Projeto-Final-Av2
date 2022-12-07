package com.tomorrow.tomorrow.services.authentication.exceptions;

public class IncorrectLoginOrPasswordException extends RuntimeException{

    public IncorrectLoginOrPasswordException(String error){
        super(error);
    }
}
