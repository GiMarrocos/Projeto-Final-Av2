package com.tomorrow.tomorrow.entities.exceptions;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String error_message){
        super(error_message);
    }
}
