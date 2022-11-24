package com.tomorrow.tomorrow.entities.exceptions;

public class TeacherCreateFailureException extends RuntimeException {
    
    public TeacherCreateFailureException(String error_message){
        super(error_message);
    }
}
