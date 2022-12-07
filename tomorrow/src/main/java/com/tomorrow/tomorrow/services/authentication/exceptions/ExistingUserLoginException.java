package com.tomorrow.tomorrow.services.authentication.exceptions;

public class ExistingUserLoginException extends RuntimeException{

    public ExistingUserLoginException(String error_message){
        super(error_message);
    }
}
