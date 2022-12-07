package com.tomorrow.tomorrow.services.authentication.exceptions;

public class InactiveUserException extends RuntimeException{

    public InactiveUserException(String msg){
        super(msg);
    }
}
