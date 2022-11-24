package com.tomorrow.tomorrow.entities.exceptions;

public class StudentCreateFailureException extends RuntimeException{

    public StudentCreateFailureException(String error_message){
        super(error_message);
    }
}
